package org.johoco.depinsight.nexus.client.nexus;

import java.util.List;

import org.johoco.depinsight.dto.AssetDTO;
import org.johoco.depinsight.dto.ComponentDTO;
import org.johoco.depinsight.dto.ComponentsDTO;
import org.johoco.depinsight.dto.Pom;
import org.johoco.depinsight.nexus.client.ArtifactRepositoryClient;
import org.johoco.depinsight.nexus.client.nexus.builder.maven.MavenSearchCriteriaBuilder;
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

	private String baseUrl = "http://localhost:8081/service/rest";
	private String versionUrl = "/v1";
	private String searchUrl = "/search";

	// search components -> /v1/search
	// search assests -> /v1/search/assets

	private String paramSplit = "&";

	private String template = "%s%s%s?%s";

	@Autowired
	public NexusV1Client(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * Download the POM using the downloadURL property.
	 */
	@Override
	public Pom download(final AssetDTO adto) {
		LOG.info(String.format("Going to download and parse %s", adto.getDownloadUrl()));
		Pom da = restTemplate.getForObject(adto.getDownloadUrl(), Pom.class);
		LOG.info("Got the POM");
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
	public List<ComponentDTO> crawlRepository(final String repository) {
		ComponentsDTO quote = restTemplate.getForObject(
				"http://localhost:8081/service/rest/v1/components?repository=maven-releases", ComponentsDTO.class);
		LOG.info("Initial getForObject" + quote.toString());

		return quote.getItems();

//		for (ComponentDTO cdto : quote.getItems()) {
//			for (AssetDTO adto : cdto.getAssets()) {
//				if (adto.getPath().endsWith("pom")) {
//					Pom pom = null;// pomDownload.download(adto);
//				}
//			}
//		}
	}

}
