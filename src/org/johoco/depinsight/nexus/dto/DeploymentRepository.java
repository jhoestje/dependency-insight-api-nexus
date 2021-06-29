package org.johoco.depinsight.nexus.dto;

import lombok.Data;

/**
 *
 *
 * @author John Hoestje
 */
@Data
public class DeploymentRepository {
	private String uniqueVersion; // boolean
	private RepositoryPolicy releases;
	private RepositoryPolicy snapshots;
	private String id;
	private String name;
	private String url;
	private String layout;
}
