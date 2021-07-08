package org.johoco.depinsight.nexus.client.nexus;

import lombok.Builder;
import lombok.Data;

/**
 * Search values related to Nexus Maven asset searches.
 * 
 * Have a parent class that has common values for all searches and subclass by type?  nuget, docker, ...
 * 
 * Is there parameter precedence?
 * 
 * @author John Hoestje
 *
 */
@Data
@Builder
public class MavenSearchCriteria {
	private String q;
	private String repository;
	private String format;
	private String group;
	private String name;
	private String version;
	private String md5;
	private String sha1;
	private String sha256;
	private String sha512;
	private String prerelease;
	private String groupId;
	private String artifactId;
	private String baseVersion;
	private String extension;
	private String classifier;
}
