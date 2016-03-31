package sp.drm.colorGreen;

import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import sp.drm.colorGreen.Green;
import sp.drm.ServicesIF.*;

import org.osgi.framework.Bundle;

public class GreenFactory implements ServiceFactory {
	
	public Object getService(Bundle bundle, ServiceRegistration reg) {
		ColorIF green = new Green();
		return green;
	}
	
	// Overload
	public Object getService(Bundle bundle, ServiceRegistration reg, Object service) {
		ColorIF green = new Green();
		return green;
	}
	
	public void ungetService(Bundle bundle, ServiceRegistration reg, Object service) {
		// services automatically released when bundle stops
	}
}
