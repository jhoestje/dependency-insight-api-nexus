package org.johoco.depinsight.nexus.client;

import org.johoco.depinsight.dto.AssetDTO;
import org.johoco.depinsight.dto.Pom;

public interface ArtifactRepositoryClient {

	Pom download(AssetDTO adto);

	void crawlRepository(final String repository);

}