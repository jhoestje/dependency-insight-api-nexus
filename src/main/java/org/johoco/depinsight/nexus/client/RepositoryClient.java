package org.johoco.depinsight.nexus.client;

import org.johoco.depinsight.dto.AssetDTO;
import org.johoco.depinsight.dto.Pom;

public interface RepositoryClient {

	Pom download(AssetDTO adto);

}