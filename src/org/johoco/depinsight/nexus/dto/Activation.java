package org.johoco.depinsight.nexus.dto;

import lombok.Data;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 *
 * @author John Hoestje
 */
@Data
public class Activation {
	private String activeByDefault; // boolean
	private String jdk;
	private ActivationOS os;
	private ActivationProperty property;
	private ActivationFile file;
}
