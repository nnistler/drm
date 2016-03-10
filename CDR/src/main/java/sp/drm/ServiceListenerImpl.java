package sp.drm;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public class ServiceListenerImpl implements ServiceListener {
	public void serviceChanged(ServiceEvent event) {
		// This is used to be alerted when the specified service is started
		// Useful for detecting when a service we are dependent on is ready, so we can start the main service.
		
	}
}