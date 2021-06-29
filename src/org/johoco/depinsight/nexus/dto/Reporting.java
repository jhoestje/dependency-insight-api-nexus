package org.johoco.depinsight.nexus.dto;

import java.util.List;

import lombok.Data;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 *
 * @author John Hoestje
 */
@Data
public class Reporting {
	private String excludeDefaults;
	private String outputDirectory;
	private List<ReportPlugin> plugins;
}
