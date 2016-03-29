package sp.drm.colorTracker;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import sp.drm.ServicesIF.ColorIF;

public class Activator implements BundleActivator {
	
	public static BundleContext bundleContext = null;
	private ServiceTracker colortracker;
	
	public void start(BundleContext bundleContext) throws Exception {
		Activator.bundleContext = bundleContext;
		log("Starting");
		ServiceTrackerCustomizer customizer = 
				new ColorTrackerCustomizer(Activator.bundleContext);
		colortracker = new ServiceTracker(bundleContext, ColorIF.class.getName(),customizer);
		colortracker.open();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		log("Stopping");
		Activator.bundleContext = null;
		colortracker.close();
	}
	
	private void log(String message) {
		System.out.println(Activator.bundleContext.getBundle()
				.getHeaders().get(Constants.BUNDLE_NAME)
                + ": " + message + ".");
	}
	
}