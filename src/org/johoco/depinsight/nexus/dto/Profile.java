package org.johoco.depinsight.nexus.dto;

import java.util.List;
import java.util.Map;

import org.eclipse.aether.collection.DependencyManagement;

import lombok.Data;

/**
 *
 *
 * @author John Hoestje
 */
@Data
public class Profile {
	private String id;
	private Activation activation;
	private BuildBase build;
	private List<String> modules;
	private DistributionManagement distributionManagement;
	// property template: <code>&lt;name&gt;value&lt;/name&gt;</code>
	private Map<String, String> properties;
	private DependencyManagement dependencyManagement;
	private List<DependencyDTO> dependency;
	private List<Repository> repositories;
	private List<Repository> pluginRepositories;
	// reports element per XSD <b>Deprecated</b>. Now ignored by Maven.
	private Reporting reporting;
}
