package org.johoco.depinsight.nexus;

import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.impl.VersionRangeResolver;
import org.eclipse.aether.resolution.VersionRangeRequest;
import org.eclipse.aether.resolution.VersionRangeResolutionException;
import org.eclipse.aether.resolution.VersionRangeResult;
import org.eclipse.aether.util.version.GenericVersionScheme;
import org.eclipse.aether.version.InvalidVersionSpecificationException;
import org.eclipse.aether.version.Version;
import org.eclipse.aether.version.VersionConstraint;
import org.eclipse.aether.version.VersionScheme;

import static java.util.Objects.requireNonNull;

public class StubVersionRangeResolver implements VersionRangeResolver {

    private final VersionScheme versionScheme = new GenericVersionScheme();

    public VersionRangeResult resolveVersionRange( RepositorySystemSession session, VersionRangeRequest request )
        throws VersionRangeResolutionException
    {
        requireNonNull( session, "session cannot be null" );
        requireNonNull( request, "request cannot be null" );
        VersionRangeResult result = new VersionRangeResult( request );
        try
        {
            VersionConstraint constraint = versionScheme.parseVersionConstraint( request.getArtifact().getVersion() );
            result.setVersionConstraint( constraint );
            if ( constraint.getRange() == null )
            {
                result.addVersion( constraint.getVersion() );
            }
            else
            {
                for ( int i = 1; i < 10; i++ )
                {
                    Version ver = versionScheme.parseVersion( Integer.toString( i ) );
                    if ( constraint.containsVersion( ver ) )
                    {
                        result.addVersion( ver );
                        if ( !request.getRepositories().isEmpty() )
                        {
                            result.setRepository( ver, request.getRepositories().get( 0 ) );
                        }
                    }
                }
            }
        }
        catch ( InvalidVersionSpecificationException e )
        {
            result.addException( e );
            throw new VersionRangeResolutionException( result );
        }

        return result;
    }

}
