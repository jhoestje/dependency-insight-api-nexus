package org.johoco.depinsight.nexus.dto;

import lombok.Data;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 *
 * @author John Hoestje
 */
@Data
public class Site {
	private String id;
	private String name;
	private String url;
	// private String child.site.url.inherit.append.path;
}
