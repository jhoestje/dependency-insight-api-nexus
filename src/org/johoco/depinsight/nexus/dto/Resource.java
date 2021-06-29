package org.johoco.depinsight.nexus.dto;

import java.util.List;

import lombok.Data;

/**
 *
 *
 * @author John Hoestje
 */
@Data
public class Resource {
	private String targetPath;
	private String filtering;
	private String directory;
	// includes pattern: A list of patterns to include, e.g. <code>**&#47;*.xml</code>
	private List<String> includes;
	// includes pattern: A list of patterns to exclude, e.g. <code>**&#47;*.xml</code>
	private List<String> excludes;
}
