package org.johoco.depinsight.nexus.client.nexus.depinsight;

import org.johoco.depinsight.dto.AssetDTO;
import org.johoco.depinsight.dto.ComponentsDTO;
import org.johoco.depinsight.dto.Pom;
import org.johoco.depinsight.nexus.client.nexus.MavenSearchCriteria;
import org.johoco.depinsight.nexus.client.nexus.builder.maven.MavenSearchCriteriaBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DependencyInsightClient {

	private final static Logger LOG = LoggerFactory.getLogger(DependencyInsightClient.class);

	private RestTemplate restTemplate;

	private String baseUrl = "http://localhost:8081/service/rest";
	private String versionUrl = "/v1";
	private String searchUrl = "/search";

	private String paramSplit = "&";

	private String template = "%s%s%s?%s";

	@Autowired
	public DependencyInsightClient(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * Download the POM using the downloadURL property.
	 */
	public Pom download(final AssetDTO adto) {
		LOG.info(String.format("Going to download and parse %s", adto.getDownloadUrl()));
		Pom da = restTemplate.getForObject(adto.getDownloadUrl(), Pom.class);
		LOG.info("Got the POM do:  " + da.toString());
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

}
