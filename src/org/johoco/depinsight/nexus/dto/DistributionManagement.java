package org.johoco.depinsight.nexus.dto;

import lombok.Data;

/**
 *
 *
 * @author John Hoestje
 */
@Data
public class DistributionManagement {
	private DeploymentRepository repository;
	private DeploymentRepository snapshotRepository;
	private Site site;
	private String downloadUrl;
	private Relocation relocation;
	private String status;
}
