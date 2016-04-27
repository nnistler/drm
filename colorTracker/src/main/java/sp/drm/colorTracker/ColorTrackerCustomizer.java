package sp.drm.colorTracker;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.osgi.framework.ServiceEvent;
import sp.drm.ServicesIF.ColorIF;

public class ColorTrackerCustomizer<ColoIF,ColorIF> implements ServiceTrackerCustomizer{

	private final BundleContext bundleContext;
	
	public ColorTrackerCustomizer(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
	}

	public Object addingService(ServiceReference serviceReference) {
		log("Adding Color Service");
		Object colorService = bundleContext.getService(serviceReference);
		return colorService;
	}

	public void modifiedService(ServiceReference serviceReference, Object someService) {
		ServiceEvent myService = null;
		myService = (ServiceEvent) someService; 
		
		switch (myService.getType()) {
		case ServiceEvent.MODIFIED:
			log("Service modified");
			//x = (ColorIF) Activator.bundleContext.getService(myService.getServiceReference());
			break;	
		default:
			break;
		}
	}

	public void removedService(ServiceReference serviceReference, Object service) {
		log("Removing Color Service");
		bundleContext.ungetService(serviceReference);
	}
	
	private void log(String message) {
		System.out.println(bundleContext.getBundle().
				getHeaders().get(Constants.BUNDLE_NAME)
				+ "-- Service Tracker: " + message + ".");
	}

}
