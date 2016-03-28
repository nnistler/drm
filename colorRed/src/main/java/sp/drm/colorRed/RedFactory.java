package sp.drm.colorRed;

import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import sp.drm.colorRed.Red;

import org.osgi.framework.Bundle;

public class RedFactory implements ServiceFactory {
	
	public Object getService(Bundle bundle, ServiceRegistration reg) {
		return new Red();
	}
	
	// Overload
	public Object getService(Bundle bundle, ServiceRegistration reg, Object service) {
		return new Red();
	}
	
	public void ungetService(Bundle bundle, ServiceRegistration reg, Object service) {
		// services automatically released when bundle stops
	}
}
