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
public class PluginExecution {
	private String id;
	private String phase;
	private List<String> goals;
	private String inherited;
	// configuration element per XSD: <xs:any minOccurs="0" maxOccurs="unbounded" processContents="skip"/>
}
