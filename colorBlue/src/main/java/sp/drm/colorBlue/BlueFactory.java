package sp.drm.colorBlue;

import sp.drm.colorBlue.Blue;

import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.Bundle;

import sp.drm.ServicesIF.*;

public class BlueFactory implements ServiceFactory {
	
	public Object getService(Bundle bundle, ServiceRegistration reg) {
		ColorIF blue = new Blue();
		return blue;
	}
	
	// Overload
	public Object getService(Bundle bundle, ServiceRegistration reg, Object service) {
		ColorIF blue = new Blue();
		return blue;
	}
	
	public void ungetService(Bundle bundle, ServiceRegistration reg, Object service) {
		// services automatically released when bundle stops
	}
}
