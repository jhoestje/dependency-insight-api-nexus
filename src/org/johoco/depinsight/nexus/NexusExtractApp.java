package org.johoco.depinsight.nexus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NexusExtractApp {
	private static final Logger log = LoggerFactory.getLogger(NexusExtractApp.class);

	public static void main(String[] args) {
		SpringApplication.run(NexusExtractApp.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate, PomDownload pomd) throws Exception {
//
//		return args -> {
//			ComponentsDTO quote = restTemplate.getForObject(
//					"http://localhost:8081/service/rest/v1/components?repository=maven-releases", ComponentsDTO.class);
//			log.info("Initial getForObject" + quote.toString());
//
//			for (ComponentDTO cdto : quote.getItems()) {
//				for (AssetDTO adto:cdto.getAssets()) {
//					if (adto.getPath().endsWith("pom")) {
//						pomd.sdf(adto);
//					}	
//				}
//			}
//		};
//	}

//	private void soeomtseotr() {
//
//		DefaultDependencyCollector collector;
//
//		DefaultRepositorySystemSession session;
//
////		DependencyGraphParser parser;
//
//		RemoteRepository repository;
//
//		session = TestUtils.newSession();
//
//		collector = new DefaultDependencyCollector();
//		collector.setArtifactDescriptorReader(newReader(""));
//		collector.setVersionRangeResolver(new StubVersionRangeResolver());
//		collector.setRemoteRepositoryManager(new StubRemoteRepositoryManager());
//
////		parser = new DependencyGraphParser("artifact-descriptions/");
//
//		repository = new RemoteRepository.Builder("id", "default", "file:///").build();
//
//		Dependency dependency = newDep("gid:aid:ext:ver", "compile");
//		CollectRequest request = new CollectRequest(dependency, Arrays.asList(repository));
//		CollectResult result = collector.collectDependencies(session, request);
//	}
//
//	private Dependency newDep(String coords, String scope) {
//		return new Dependency(new DefaultArtifact(coords), scope);
//	}
//	
//    private IniArtifactDescriptorReader newReader( String prefix )
//    {
//        return new IniArtifactDescriptorReader( "artifact-descriptions/" + prefix );
//    }
//    
//    private void sadf() {
//    	RepositorySystem repoSystem = newRepositorySystem();
//    	 
//        RepositorySystemSession session = newSession( repoSystem );
// 
//        Dependency dependency =
//            new Dependency( new DefaultArtifact( "org.apache.maven:maven-profile:2.2.1" ), "compile" );
//        RemoteRepository central = new RemoteRepository.Builder( "central", "default", "http://repo1.maven.org/maven2/" ).build();
// 
//        CollectRequest collectRequest = new CollectRequest();
//        collectRequest.setRoot( dependency );
//        collectRequest.addRepository( central );
//        DependencyNode node = repoSystem.collectDependencies( session, collectRequest ).getRoot();
// 
//        DependencyRequest dependencyRequest = new DependencyRequest();
//        dependencyRequest.setRoot( node );
// 
//        repoSystem.resolveDependencies( session, dependencyRequest  );
// 
//        PreorderNodeListGenerator nlg = new PreorderNodeListGenerator();
//        node.accept( nlg );
//        System.out.println( nlg.getClassPath() );
//    }
//    
//    private static RepositorySystemSession newSession( RepositorySystem system )
//    {
//        DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();
// 
//        LocalRepository localRepo = new LocalRepository( "target/local-repo" );
//        session.setLocalRepositoryManager( system.newLocalRepositoryManager( session, localRepo ) );
// 
//        return session;
//    }

//    public static RepositorySystem newRepositorySystem()
//    {
//        /*
//         * Aether's components implement org.eclipse.aether.spi.locator.Service to ease manual wiring and using the
//         * prepopulated DefaultServiceLocator, we only need to register the repository connector and transporter
//         * factories.
//         */
//        DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
//        locator.addService( RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class );
//        locator.addService( TransporterFactory.class, FileTransporterFactory.class );
//        locator.addService( TransporterFactory.class, HttpTransporterFactory.class );
//
//        locator.setErrorHandler( new DefaultServiceLocator.ErrorHandler()
//        {
//            @Override
//            public void serviceCreationFailed( Class<?> type, Class<?> impl, Throwable exception )
//            {
//               LOGGER.error( "Service creation failed for {} with implementation {}",
//                        type, impl, exception );
//            }
//        } );
//
//        return locator.getService( RepositorySystem.class );
//    }

//    public static final String SERVICE_LOCATOR = "serviceLocator";
//
//    public static final String GUICE = "guice";
//
//    public static final String SISU = "sisu";

//    public static RepositorySystem newRepositorySystem( final String factory )
//    {
//        switch ( factory ) 
//        {
//            case SERVICE_LOCATOR:
//                return org.apache.maven.resolver.examples.manual.ManualRepositorySystemFactory.newRepositorySystem();
//            case GUICE:
//                return org.apache.maven.resolver.examples.guice.GuiceRepositorySystemFactory.newRepositorySystem();
//            case SISU:
//                return org.apache.maven.resolver.examples.sisu.SisuRepositorySystemFactory.newRepositorySystem();
//            default:
//                throw new IllegalArgumentException( "Unknown factory: " + factory );
//        }
//    }
}
