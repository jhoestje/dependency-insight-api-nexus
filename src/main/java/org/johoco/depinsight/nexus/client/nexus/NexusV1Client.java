package org.johoco.depinsight.nexus.client.nexus;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.johoco.depinsight.dto.AssetDTO;
import org.johoco.depinsight.dto.ComponentDTO;
import org.johoco.depinsight.dto.ComponentsDTO;
import org.johoco.depinsight.dto.Pom;
import org.johoco.depinsight.nexus.client.ArtifactRepositoryClient;
import org.johoco.depinsight.nexus.client.nexus.builder.maven.MavenSearchCriteriaBuilder;
import org.johoco.depinsight.nexus.client.nexus.depinsight.DependencyInsightClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NexusV1Client implements ArtifactRepositoryClient {

	private final static Logger LOG = LoggerFactory.getLogger(NexusV1Client.class);

//	@Autowired
//	private RestTemplateBuilder restTemplateBuilder;

	private RestTemplate restTemplate;
	private DependencyInsightClient depInsightClient;

	private String baseUrl = "http://localhost:8081/service/rest";
	private String versionUrl = "/v1";
	private String searchUrl = "/search";

	// search components -> /v1/search
	// search assests -> /v1/search/assets

	private String paramSplit = "&";

	private String template = "%s%s%s?%s";

	private static int counter = 0;

	@Autowired
	public NexusV1Client(final RestTemplate restTemplate, DependencyInsightClient depInsightClient) {
		this.restTemplate = restTemplate;
		this.depInsightClient = depInsightClient;
	}

	/**
	 * Download the POM using the downloadURL property.
	 */
	@Override
	public Pom download(final AssetDTO adto) {
		LOG.info(String.format("Going to download and parse %s", adto.getDownloadUrl()));
		Pom da = restTemplate.getForObject(adto.getDownloadUrl(), Pom.class);
		// LOG.info("Got the POM");
		return da;
	}

	public ComponentsDTO find(final MavenSearchCriteria values) {
		MavenSearchCriteriaBuilder vb = new MavenSearchCriteriaBuilder();
		String queryUrl = vb.searchBuilder(values, paramSplit);
		String fullUrl = String.format(template, baseUrl, versionUrl, searchUrl, queryUrl);

		LOG.info("Nexus URL:  " + fullUrl);

		ComponentsDTO components = restTemplate.getForObject(fullUrl, ComponentsDTO.class);
		LOG.info(components.toString());

		return components;
	}

	@Override
	public void crawlRepository(final String repository) {
//		ComponentsDTO quote = restTemplate.getForObject(
//				"http://localhost:8081/service/rest/v1/components?repository=maven-releases", ComponentsDTO.class);
//		ComponentsDTO components = restTemplate.getForObject(
//				"http://localhost:8081/service/rest/v1/components?repository=" + repository, ComponentsDTO.class);
		LOG.info("Initial getForObject" + repository);

		this.crawlRepository(repository, null);
		//

	}

	public void crawlRepository(final String repository, final String continuationToken) {
		String ct = "";
		if (!StringUtils.isBlank(continuationToken)) {
			ct = String.format("continuationToken=%s%s", continuationToken, "&");
		}
		String url = String.format("http://localhost:8081/service/rest/v1/components?%srepository=%s", ct, repository);
		LOG.debug("Calling for components on url {}", url);
		ComponentsDTO components = restTemplate.getForObject(url, ComponentsDTO.class);
		List<ComponentDTO> found = components.getItems();

		LOG.info("Crawling repository {} continuationToken {} found {} components", repository, continuationToken,
				found.size());

		String newCT = components.getContinuationToken();

		for (ComponentDTO cdto : found) {
			for (AssetDTO adto : cdto.getAssets()) {
				if (adto.getPath().endsWith("pom")) {
					++counter;
					Pom pom = this.download(adto);
					checkForInheritedValues(pom);
					// LOG.info("POM DLd");
					depInsightClient.save(pom);
				}
			}
		}
		LOG.warn("Counter:  " + counter);
		if (!StringUtils.isBlank(newCT)) {
			crawlRepository(repository, newCT);
		}
	}

	/**
	 * In case values are inherited
	 * 
	 * @return
	 */
	private void checkForInheritedValues(Pom pom) {
		if (StringUtils.isBlank(pom.getGroupId()) && pom.getParent() != null) {
			pom.setGroupId(pom.getParent().getGroupId());
		}
		if (StringUtils.isBlank(pom.getVersion()) && pom.getParent() != null) {
			pom.setVersion(pom.getParent().getVersion());
		}
	}

}
