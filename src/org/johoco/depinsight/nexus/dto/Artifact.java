package org.johoco.depinsight.nexus.dto;

import lombok.Data;

@Data
public class Artifact {
	private String artifactId;
	private String groupId;
	private String version;
}
