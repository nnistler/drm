package sp.drm.colorMixer;

import sp.drm.colorMixer.ColorMixer;

import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.Bundle;

import sp.drm.ServicesIF.*;

public class ColorFactory implements ServiceFactory {
	
	public Object getService(Bundle bundle, ServiceRegistration reg) {
		ColorIF color = new ColorMixer();
		return color;
	}
	
	// Overload
	public Object getService(Bundle bundle, ServiceRegistration reg, Object service) {
		ColorIF color = new ColorMixer();
		return color;
	}
	
	public void ungetService(Bundle bundle, ServiceRegistration reg, Object service) {
		// services automatically released when bundle stops
	}
}
