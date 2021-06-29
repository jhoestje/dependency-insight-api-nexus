package org.johoco.depinsight.nexus.dto;

import java.util.List;

import lombok.Data;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 *
 * @author John Hoestje
 */
@Data
public class DependencyDTO {
	private String groupId;
	private String artifactId;
	private String version;
	private String type;
	private String classifier;
	private String scope;
	private String systemPath;
	List<Exclusion> exclusions;
	private String optional;
}
