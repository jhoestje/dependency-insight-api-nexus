package org.johoco.depinsight.nexus.client.nexus.depinsight;

import org.johoco.depinsight.dto.ComponentsDTO;
import org.johoco.depinsight.dto.Pom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DependencyInsightClient {

	private final static Logger LOGR = LoggerFactory.getLogger(DependencyInsightClient.class);

	private RestTemplate restTemplate;

	private String baseUrl = "http://localhost:8080/artifact/create/pom";

	@Autowired
	public DependencyInsightClient(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * Download the POM using the downloadURL property.
	 */
	public void save(final Pom pom) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Pom> request = new HttpEntity<Pom>(pom, headers);

		ResponseEntity<String> responseEntityStr = restTemplate.postForEntity(baseUrl, request, String.class);

		LOGR.debug(responseEntityStr.getBody());
	}

	public ComponentsDTO find(final Pom pom) {
		String fullUrl = baseUrl;

		LOGR.info("Nexus URL:  " + fullUrl);

		ComponentsDTO components = restTemplate.getForObject(fullUrl, ComponentsDTO.class);
		LOGR.info(components.toString());

		return components;
	}

}
