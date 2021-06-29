package org.johoco.depinsight.nexus.dto;

import lombok.Data;

/**
 *
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
