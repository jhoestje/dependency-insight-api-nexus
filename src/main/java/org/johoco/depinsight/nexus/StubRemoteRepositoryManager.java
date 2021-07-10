package org.johoco.depinsight.nexus;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.impl.RemoteRepositoryManager;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.repository.RepositoryPolicy;

import static java.util.Objects.requireNonNull;

public class StubRemoteRepositoryManager implements RemoteRepositoryManager {

    public StubRemoteRepositoryManager()
    {
    }

    public List<RemoteRepository> aggregateRepositories( RepositorySystemSession session,
                                                         List<RemoteRepository> dominantRepositories,
                                                         List<RemoteRepository> recessiveRepositories,
                                                         boolean recessiveIsRaw )
    {
        requireNonNull( session, "session cannot be null" );
        requireNonNull( dominantRepositories, "dominantRepositories cannot be null" );
        requireNonNull( recessiveRepositories, "recessiveRepositories cannot be null" );
        return dominantRepositories;
    }

    public RepositoryPolicy getPolicy( RepositorySystemSession session, RemoteRepository repository, boolean releases,
                                       boolean snapshots )
    {
        requireNonNull( session, "session cannot be null" );
        requireNonNull( repository, "repository cannot be null" );
        RepositoryPolicy policy = repository.getPolicy( snapshots );

        String checksums = session.getChecksumPolicy();
        if ( StringUtils.isEmpty( checksums ) )
        {
            checksums = policy.getChecksumPolicy();
        }
        String updates = session.getUpdatePolicy();
        if ( StringUtils.isEmpty( updates ) )
        {
            updates = policy.getUpdatePolicy();
        }

        policy = new RepositoryPolicy( policy.isEnabled(), updates, checksums );

        return policy;
    }

}
