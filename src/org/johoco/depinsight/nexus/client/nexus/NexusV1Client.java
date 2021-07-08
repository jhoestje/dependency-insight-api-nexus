package org.johoco.depinsight.nexus.client.nexus;

import org.johoco.depinsight.dto.AssetDTO;
import org.johoco.depinsight.dto.AssetsDTO;
import org.johoco.depinsight.dto.Pom;
import org.johoco.depinsight.nexus.client.RepositoryClient;
import org.johoco.depinsight.nexus.client.nexus.builder.maven.MavenSearchCriteriaBuilder;
import org.johoco.depinsight.nexus.controller.NexusController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NexusV1Client implements RepositoryClient {

	private final static Logger LOG = LoggerFactory.getLogger(NexusController.class);

//	@Autowired
//	private RestTemplateBuilder restTemplateBuilder;

	private RestTemplate restTemplate;

	private String baseUrl = "http://localhost:8081/service/rest";
	private String versionUrl = "/v1";
	private String searchUrl = "/search";
	
	
	// search components -> /v1/search
	//search assests -> /v1/search/assets

	private String paramSplit = "&";

	private String template = "&s&s&s?&s";

	private static final Logger log = LoggerFactory.getLogger(NexusV1Client.class);

	@Autowired
	public NexusV1Client(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * Download the POM using the downloadURL property.
	 */
	@Override
	public Pom download(final AssetDTO adto) {
		log.info(String.format("Going to download and parse %s", adto.getDownloadUrl()));
		Pom da = restTemplate.getForObject(adto.getDownloadUrl(), Pom.class);
		log.info("Got the POM do:  " + da.toString());
		return da;
	}

	public AssetsDTO find(final MavenSearchCriteria values) {
		MavenSearchCriteriaBuilder vb = new MavenSearchCriteriaBuilder();
		String queryUrl = vb.searchBuilder(values, paramSplit);
		String fullUrl = String.format(template, baseUrl, versionUrl, searchUrl, queryUrl);

		AssetsDTO assets = restTemplate.getForObject(fullUrl, AssetsDTO.class);
		LOG.info(assets.toString());

		return null;
	}

	
}
