package org.johoco.depinsight.nexus.dto;

import lombok.Data;

/**
 *
 *
 * @author John Hoestje
 */
@Data
public class ActivationOS {
	private String name;
	private String family;
	private String arch;
	private String version;
}
