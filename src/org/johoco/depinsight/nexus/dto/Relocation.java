package org.johoco.depinsight.nexus.dto;

import lombok.Data;

/**
 * Where an artifact has moved to.
 *
 * @author John Hoestje
 */
@Data
public class Relocation {
	private String groupId;
	private String artifactId;
	private String version;
	private String message;
}
