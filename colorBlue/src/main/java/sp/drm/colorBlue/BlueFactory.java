package sp.drm.colorBlue;

import sp.drm.colorBlue.Blue;

import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.Bundle;

public class BlueFactory implements ServiceFactory {
	
	public Object getService(Bundle bundle, ServiceRegistration reg) {
		return new Blue();
	}
	
	// Overload
	public Object getService(Bundle bundle, ServiceRegistration reg, Object service) {
		return new Blue();
	}
	
	public void ungetService(Bundle bundle, ServiceRegistration reg, Object service) {
		// services automatically released when bundle stops
	}
}
