package sp.drm;

import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import sp.drm.interfaces.DependencyResolver;

public class Activator implements BundleActivator {
	//private static BundleContext bc;
	//private static Scanner sc = new Scanner(System.in);

	public void start(BundleContext bc) throws Exception {
		System.out.println("Starting Client Dependency Resolver.");
		//Activator.bc = bc;
		// TODO Start the service here
		// TODO Establish connection with the central server
		// ServerFactory provides an indirection step towards starting a service
		DependencyResolver resolver = new ClientDependencyResolver(bc);
		// Registering a service
		Properties props = new Properties();
		//props.setProperty("hash", "a94a8fe5ccb19ba61c4c0873d391e987982fbbd3"); // "test" in SHA-1
		bc.registerService(DependencyResolver.class.getName(), resolver, props);
		// Fetching a service
		/*ServiceReference sref = bc.getServiceReference(resolver.getClass().getName());
		if (sref.getProperty("hash").equals("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3")) {
			bc.getService(sref); // This is the service we are interested in
			// Do something with this
			bc.ungetService(sref); // Clean up
		}*/
		//while (sc.hasNextLine()) {
			/*String jarFileName = "/Users/jonathanhuang/drm/libs/knopflerfish_osgi_5.2.0/osgi/project_jars/rgbBlue.jar";//sc.nextLine();
			File jarFile = new File(jarFileName);
			if (jarFile.exists()) {
				FileInputStream fis = new FileInputStream(jarFile);
				Bundle b = bc.installBundle("ColorBundleExample", fis);
				
				b.start();
				fis.close();
			} else {
				System.out.println("JAR File does not exist.");
			}*/
		//}
	}

	public void stop(BundleContext bc) throws Exception {
		System.out.println("Stopping Client Dependency Resolver.");
		//Activator.bc = null;
		// TODO Cleanup methods (closing files, connections, etc.)
	}
}