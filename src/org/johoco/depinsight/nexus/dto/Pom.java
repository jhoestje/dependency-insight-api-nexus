package org.johoco.depinsight.nexus.dto;

import java.util.List;
import java.util.Map;

import org.eclipse.aether.collection.DependencyManagement;
import org.eclipse.aether.graph.Dependency;

import lombok.Data;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 * 
 * @author John Hoestje
 *
 */
@Data
public class Pom {
	private String modelVersion;
	private Artifact parent;

	private String groupId;
	private String artifactId;
	private String version;
	private String packaging;
	private String name;
	private String description;
	private String url;
	private String inceptionYear;
	private Organization organization;
	private List<License> licenses;
	private List<Developer> developers;
	private List<Contributor> contributors;
	private List<MailingLists> mailingLists;
	private Prerequisites prerequisites;
	private List<String> modules;
	private Scm scm;
	private IssueManagement issueManagement;
	private CiManagement ciManagement;
	private DistributionManagement distributionManagement;
	// aether
	private List<DependencyManagement> dependencyManagement;
	private List<Dependency> dependencies;
	private Map<String, String> properties;
	private List<Repository> repositories;
	private List<Repository> pluginRepositories;
	private Build build;
	// reports element per XSD <b>Deprecated</b>. Now ignored by Maven.
	private Reporting reporting;
	private List<Profile> profiles;

}
