package org.johoco.depinsight.nexus;

import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.impl.ArtifactDescriptorReader;
import org.eclipse.aether.resolution.ArtifactDescriptorException;
import org.eclipse.aether.resolution.ArtifactDescriptorRequest;
import org.eclipse.aether.resolution.ArtifactDescriptorResult;

public class IniArtifactDescriptorReader implements ArtifactDescriptorReader {

    /**
     * Use the given prefix to load the artifact descriptions.
     */
    public IniArtifactDescriptorReader( String prefix )
    {
       //super( prefix );
    }

	@Override
	public ArtifactDescriptorResult readArtifactDescriptor(RepositorySystemSession session,
			ArtifactDescriptorRequest request) throws ArtifactDescriptorException {
		// TODO Auto-generated method stub
		return null;
	}

}
