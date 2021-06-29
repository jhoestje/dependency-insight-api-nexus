package org.johoco.depinsight.nexus.dto;

import java.util.List;

import lombok.Data;

/**
 *
 *
 * @author John Hoestje
 */
@Data
public class BuildBase {
	private String defaultGoal;
	private List<Resource> resources;
	private List<Resource> testResources;
	private String directory;
	private String finalName;
	private List<String> filters;
	private PluginManagement pluginManagement;
	private List<Plugin> plugins;

}
