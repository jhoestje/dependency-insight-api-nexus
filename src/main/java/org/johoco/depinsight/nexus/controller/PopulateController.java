package org.johoco.depinsight.nexus.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.johoco.depinsight.dto.AssetDTO;
import org.johoco.depinsight.dto.AssetsDTO;
import org.johoco.depinsight.dto.ComponentDTO;
import org.johoco.depinsight.dto.ComponentsDTO;
import org.johoco.depinsight.dto.Pom;
import org.johoco.depinsight.nexus.client.nexus.MavenSearchCriteria;
import org.johoco.depinsight.nexus.client.nexus.NexusV1Client;
import org.johoco.depinsight.nexus.client.nexus.depinsight.DependencyInsightClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/populate")
public class PopulateController {
	private final static Logger LOG = LoggerFactory.getLogger(PopulateController.class);

	private RestTemplate restTemplate;
	private NexusV1Client client;
	private DependencyInsightClient depInsightClient;

	@Autowired
	public PopulateController(final RestTemplate restTemplate, final NexusV1Client client,
			final DependencyInsightClient depInsightClient) {
		this.restTemplate = restTemplate;
		this.client = client;
		this.depInsightClient = depInsightClient;
	}

	// need to fork Apache Nexus resolver and make a local (file) vs remote (in
	// memory) version

//	@GetMapping("/find/language/{lang}/g/{groupId}/a/{artifactId}/v/{version}/p/{packaging}")
//	public ArtifactDTO getArtifact(@PathVariable("lang") final String language,
//			@PathVariable("groupId") final String groupId, @PathVariable("artifactId") final String artifactId,
//			@PathVariable("version") final String version, @PathVariable("packaging") final String packaging) {
//		final ArtifactKey key = new ArtifactKey(groupId, artifactId, version, packaging);
//		ArtifactDTO found = ArtifactConverter.convert(this.api.find(key));
//		// return 404 otherwise 200
//		return found;
//	}

	@GetMapping("/shallow")
	public void populateShallow() {
		ComponentsDTO quote = restTemplate.getForObject(
				"http://localhost:8081/service/rest/v1/components?repository=maven-releases", ComponentsDTO.class);
		LOG.info("Initial getForObject" + quote.toString());

		for (ComponentDTO cdto : quote.getItems()) {
			for (AssetDTO adto : cdto.getAssets()) {
				if (adto.getPath().endsWith("pom")) {
					Pom pom = null;// pomDownload.download(adto);
				}
			}
		}
	}

	@GetMapping("/shallow/language/{lang}/g/{groupId}/a/{artifactId}/v/{version}/p/{packaging}")
	public void populateShallowByKeyzz(@PathVariable("lang") final String language,
			@PathVariable("groupId") final String groupId, @PathVariable("artifactId") final String artifactId,
			@PathVariable("version") final String version, @PathVariable("packaging") final String packaging) {
//		ComponentsDTO quote = restTemplate.getForObject("http://localhost:8081/service/rest/v1/components?repository=maven-releases", ComponentsDTO.class);
//		LOG.info("Initial getForObject" + quote.toString());

		MavenSearchCriteria c = MavenSearchCriteria.builder().groupId(groupId).artifactId(artifactId).version(version)
				.extension(packaging).format("maven2").build();

		LOG.info("-----searching.... " + c.toString());

		ComponentsDTO comps = client.find(c);

		for (ComponentDTO comp : comps.getItems()) {
			LOG.info("------->  " + comp.toString());
			for (AssetDTO adto : comp.getAssets()) {
				if (adto.getPath().endsWith("pom")) {
					Pom pom = client.download(adto);

					checkForInheritedValues(pom);

					LOG.info("POM DLd:  " + pom.toString());
					depInsightClient.save(pom);
				}
			}
		}

	}

	@GetMapping("/shallow/crawl/{repository}")
	public void populateShallowCrawl(@PathVariable("repository") final String repository) {
		List<ComponentDTO> found = client.crawlRepository(repository);
		LOG.info("Crawling repository {} found {} components", repository, found.size());

		for (ComponentDTO cdto : found) {
			for (AssetDTO adto : cdto.getAssets()) {
				if (adto.getPath().endsWith("pom")) {
					Pom pom = client.download(adto);
					checkForInheritedValues(pom);
					LOG.info("POM DLd");
					depInsightClient.save(pom);
				}
			}
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

	@GetMapping("/deep")
	public void populateDeep() {

		AssetsDTO quote = restTemplate.getForObject(
				"http://localhost:8081/service/rest/v1/assets?repository=maven-releases", AssetsDTO.class);
		LOG.info(quote.toString());

//		Pom quote = restTemplate.getForObject(
//				"http://localhost:8081/service/rest/v1/assets?repository=maven-releases", AssetsDTO.class);
//		LOG.info(quote.toString());

	}
}
