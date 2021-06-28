package org.johoco.depinsight.nexus.dto;

import lombok.Data;

@Data
public class Pom {
	private String modelVersion;
	private Artifact parent;

	private String name;
	private String artifactId;
	private String packaging;
}
