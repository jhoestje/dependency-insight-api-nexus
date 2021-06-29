package org.johoco.depinsight.nexus.dto;

import lombok.Data;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 * 
 * May be merged with Exclusion??
 *
 * @author John Hoestje
 */
@Data
public class Exclusion {
	private String groupId;
	private String artifactId;
}
