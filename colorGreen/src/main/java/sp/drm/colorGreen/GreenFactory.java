package sp.drm.colorGreen;

import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import sp.drm.colorGreen.Green;

import org.osgi.framework.Bundle;

public class GreenFactory implements ServiceFactory {
	
	public Object getService(Bundle bundle, ServiceRegistration reg) {
		return new Green();
	}
	
	// Overload
	public Object getService(Bundle bundle, ServiceRegistration reg, Object service) {
		return new Green();
	}
	
	public void ungetService(Bundle bundle, ServiceRegistration reg, Object service) {
		// services automatically released when bundle stops
	}
}
