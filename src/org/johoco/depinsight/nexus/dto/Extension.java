package org.johoco.depinsight.nexus.dto;

import lombok.Data;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 * 
 * @author John Hoestje
 *
 */
@Data
public class Extension {
	private String groupId;
	private String artifactId;
	private String Version;
}
