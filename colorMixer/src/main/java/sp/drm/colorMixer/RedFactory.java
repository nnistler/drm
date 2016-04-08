package sp.drm.colorMixer;

import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import sp.drm.colorMixer.Red;
import sp.drm.ServicesIF.*;

import org.osgi.framework.Bundle;


public class RedFactory implements ServiceFactory {
	
	public Object getService(Bundle bundle, ServiceRegistration reg) {
		ColorIF red =  new Red();
		return red;
	}
	
	// Overload
	public Object getService(Bundle bundle, ServiceRegistration reg, Object service) {
		ColorIF red =  new Red();
		return red;
	}
	
	public void ungetService(Bundle bundle, ServiceRegistration reg, Object service) {
		// services automatically released when bundle stops
	}
}
