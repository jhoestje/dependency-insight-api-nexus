package org.johoco.depinsight.nexus;

import org.johoco.depinsight.nexus.dto.AssetsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nexus")
public class NexusController {
	private final static Logger LOG = LoggerFactory.getLogger(NexusController.class);
	
	private RestTemplate restTemplate;

	@Autowired
	public NexusController(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	// need to fork Apache Nexus resolver and make a local (file) vs remote (in memory) version

//	@GetMapping("/find/language/{lang}/g/{groupId}/a/{artifactId}/v/{version}/p/{packaging}")
//	public ArtifactDTO getArtifact(@PathVariable("lang") final String language,
//			@PathVariable("groupId") final String groupId, @PathVariable("artifactId") final String artifactId,
//			@PathVariable("version") final String version, @PathVariable("packaging") final String packaging) {
//		final ArtifactKey key = new ArtifactKey(groupId, artifactId, version, packaging);
//		ArtifactDTO found = ArtifactConverter.convert(this.api.find(key));
//		// return 404 otherwise 200
//		return found;
//	}

	@GetMapping("/find")
	public void getArtifact() {

		AssetsDTO quote = restTemplate.getForObject(
				"http://localhost:8081/service/rest/v1/assets?repository=maven-releases", AssetsDTO.class);
		LOG.info(quote.toString());
		
		
//		Pom quote = restTemplate.getForObject(
//				"http://localhost:8081/service/rest/v1/assets?repository=maven-releases", AssetsDTO.class);
//		LOG.info(quote.toString());
		
	}
}
