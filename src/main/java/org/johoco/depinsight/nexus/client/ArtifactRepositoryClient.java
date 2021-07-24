package org.johoco.depinsight.nexus.client;

import java.util.List;

import org.johoco.depinsight.dto.AssetDTO;
import org.johoco.depinsight.dto.ComponentDTO;
import org.johoco.depinsight.dto.Pom;

public interface ArtifactRepositoryClient {

	Pom download(AssetDTO adto);

	List<ComponentDTO> crawlRepository(final String repository);

}