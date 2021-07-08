package org.johoco.depinsight.nexus.client.nexus;

import org.johoco.depinsight.dto.AssetDTO;
import org.johoco.depinsight.dto.Pom;
import org.johoco.depinsight.nexus.client.RepositoryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NexusClient implements RepositoryClient {

//	@Autowired
//	private RestTemplateBuilder restTemplateBuilder;

	@Autowired
	private RestTemplate restT;
	
	private String baseUrl = "http://localhost:8081/service/rest";
	private String versionUrl = "/v1";
	private String searchUrl = "/search";

	private static final Logger log = LoggerFactory.getLogger(NexusClient.class);

	/**
	 * Download the POM using the downloadURL.
	 */
	@Override
	public Pom download(final AssetDTO adto) {
		log.info(String.format("Going to download and parse %s", adto.getDownloadUrl()));
		Pom da = restT.getForObject(adto.getDownloadUrl(), Pom.class);
		log.info("Got the POM do:  " + da.toString());
		return da;
	}
	
	
	private String searchBuilder() {
		return SearchParams.CONAN_BASEVERSION.getParam();
	}
}
