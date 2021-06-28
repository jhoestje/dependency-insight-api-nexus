package org.johoco.depinsight.nexus;

import org.johoco.depinsight.nexus.dto.AssetDTO;
import org.johoco.depinsight.nexus.dto.Pom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PomDownload {

//	@Autowired
//	private RestTemplateBuilder restTemplateBuilder;

	@Autowired
	private RestTemplate restT;

	private static final Logger log = LoggerFactory.getLogger(NexusExtractApp.class);

	public void sdf(final AssetDTO adto) {
//		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_XML));
//		messageConverters.add(converter);
//
//		restTemplateBuilder.additionalMessageConverters(messageConverters);
//		RestTemplate restTemplate = restTemplateBuilder.build();

		// restTemplate = new RestTemplate();

		log.info(String.format("Going to download and parse %s", adto.getDownloadUrl()));

		// restTemplate.setMessageConverters(messageConverters);

		Pom da = restT.getForObject(adto.getDownloadUrl(), Pom.class);

		log.info(da.toString());
	}
}
