package sp.drm.colorMixer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.Hashtable;

import sp.drm.ServicesIF.*;
import sp.drm.colorMixer.*;

public class Activator implements BundleActivator {
	
	public static BundleContext bundleContext = null;
	private ColorMixer mixer = null;
	
	public void start(BundleContext bundleContext) throws Exception {
		Activator.bundleContext = bundleContext;
		log("started");
		
		bundleContext.registerService(
				ColorMixer.class.getName(),new ColorFactory(),new Hashtable<String,String>());
		
		ServiceReference ref = bundleContext.getServiceReference(ColorMixer.class.getName());
		mixer = (ColorMixer) bundleContext.getService(ref);
	
		
		if(mixer != null) {
			mixer.draw();
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		log("stopped");
		mixer = null;
		Activator.bundleContext = null;
	}
	
	public void log(String message) {
		System.out.println("colorMixer: " + message + ".");
	}
}