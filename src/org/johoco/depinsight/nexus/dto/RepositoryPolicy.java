package org.johoco.depinsight.nexus.dto;

import lombok.Data;

/**
 *
 *
 * @author John Hoestje
 */
@Data
public class RepositoryPolicy {
	private String enabled;
	private String updatePolicy;
	private String checksumPolicy;
}
