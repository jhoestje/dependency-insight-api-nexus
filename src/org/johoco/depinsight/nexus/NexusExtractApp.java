package org.johoco.depinsight.nexus;

import org.johoco.depinsight.nexus.dto.AssetsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NexusExtractApp {
	private static final Logger log = LoggerFactory.getLogger(NexusExtractApp.class);

	public static void main(String[] args) {
		SpringApplication.run(NexusExtractApp.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		
		return args -> {
			AssetsDTO quote = restTemplate.getForObject(
					"http://localhost:8081/service/rest/v1/assets?repository=maven-releases", AssetsDTO.class);
			log.info(quote.toString());
		};
	}
}
