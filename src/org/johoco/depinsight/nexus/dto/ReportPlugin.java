package org.johoco.depinsight.nexus.dto;

import java.util.List;

import lombok.Data;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 *
 * @author John Hoestje
 */
@Data
public class ReportPlugin {
	private String groupId;
	private String artifactId;
	private String version;
	private List<ReportSet> reportSets;
	private String inherited;
	// configuration element per XSD <xs:any minOccurs="0" maxOccurs="unbounded" processContents="skip"/>
	// this may be a free form area to map
}
