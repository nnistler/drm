package sp.drm.colorTracker;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import sp.drm.ServicesIF.ColorIF;

public class ColorTrackerCustomizer implements ServiceTrackerCustomizer{

	private final BundleContext bundleContext;
	
	public ColorTrackerCustomizer(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
	}
	
	public Object addingService(ServiceReference serviceReference) {
		log("Adding Color Service");
		ColorIF colorService = (ColorIF) bundleContext.getService(serviceReference);
		return colorService;
	}

	public void modifiedService(ServiceReference serviceReference, Object service) {
		// TODO update/reinitialize some service
	}

	public void removedService(ServiceReference serviceReference, Object service) {
		log("Removing Color Service");
		bundleContext.ungetService(serviceReference);
	}
	
	private void log(String message) {
		System.out.println(bundleContext.getBundle().
				getHeaders().get(Constants.BUNDLE_NAME)
				+ "-- tracker: " + message + ".");
	}

}
