package sp.drm;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

public class CDRServiceFactory implements ServiceFactory {
	private int refCount = 0;

	public Object getService(Bundle bundle, ServiceRegistration registration) {
		System.out.println("Creating service for " + bundle.getSymbolicName());
		refCount++;
		return null;
	}

	public void ungetService(Bundle bundle, ServiceRegistration registration, Object service) {
		System.out.println("Destroyed service for " + bundle.getSymbolicName());
		refCount--;
		if (refCount == 0) {
			// this service is no longer in use, clean up
			// TODO Call any clean-up methods on the service object
		}
	}
}