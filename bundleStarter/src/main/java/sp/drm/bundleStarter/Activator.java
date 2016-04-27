package sp.drm.bundleStarter;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	
	public static BundleContext bundleContext = null;
	private Bundle bundle = null;
	private String bundlePath = "file:PATH_TO_JAR";
	
	public void start(BundleContext bundleContext) throws Exception {
		Activator.bundleContext = bundleContext;
		log("started");
		bundle = bundleContext.installBundle(bundlePath);
		if(bundle != null) {
			bundle.start();
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		log("stopped");
		Activator.bundleContext = null;
		if(bundle != null) {
			bundle.stop();
			bundle.uninstall();
		}
	}
	
	public void log(String message) {
		System.out.println("bundleStarter: " + message + ".");
	}
}