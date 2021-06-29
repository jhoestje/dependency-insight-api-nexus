package org.johoco.depinsight.nexus.dto;

import java.util.List;

import lombok.Data;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 * 
 * @author John Hoestje
 *
 */
@Data
public class Resources {
	private String targetPath;
	private String filtering;
	private String directory;
	// example includes <code>**&#47;*.xml</code>
	List<String> includes;
	List<Excludes> excludes;
}
