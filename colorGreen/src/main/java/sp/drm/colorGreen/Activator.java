package sp.drm.colorGreen;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceReference;

import sp.drm.colorGreen.GreenFactory;
import java.util.Hashtable;

import sp.drm.ServicesIF.*;

public class Activator implements BundleActivator {
	
	public static BundleContext bundleContext = null;
	private ColorIF colorService = null;
	
	public void start(BundleContext bundleContext) throws Exception {
		Activator.bundleContext = bundleContext;
		
		log("started");
		ServiceFactory serviceFactory = new GreenFactory();
		bundleContext.registerService(
				ColorIF.class.getName(),serviceFactory,new Hashtable<String,String>());
		
		ServiceReference ref = bundleContext.getServiceReference(ColorIF.class.getName());
		colorService = (ColorIF) bundleContext.getService(ref);
		
		if(colorService != null) {
			colorService.draw();
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		log("stopped");
		colorService = null;
		Activator.bundleContext = null;
	}
	
	public void log(String message) {
		System.out.println("colorGreen: " + message + ".");
	}
}