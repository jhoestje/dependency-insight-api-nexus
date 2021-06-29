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
public class Build {
	private String sourceDirectory;
	private String scriptSourceDirectory;
	private String testSourceDirectory;
	private String outputDirectory;
	private String testOutputDirectory;
	private List<Extension> extensions;
	private String defaultGoal;
	private List<Resources> resources;
	private List<Resources> testResources;
	private String directory;
	private String finalName;
	private List<String> filters;
	private List<Plugin> pluginManagement;
	private List<Plugin> plugins;
}
