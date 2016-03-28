package sp.drm.colorRed;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceReference;

import sp.drm.colorRed.Red;
import sp.drm.colorRed.RedFactory;

import java.util.Hashtable;

public class Activator implements BundleActivator {
	
	public static BundleContext bundleContext = null;
	private Red colorService = null;
	
	public void start(BundleContext bundleContext) throws Exception {
		Activator.bundleContext = bundleContext;
		
		log("started");
		ServiceFactory serviceFactory = new RedFactory();
		bundleContext.registerService(
				Red.class.getName(),serviceFactory,new Hashtable<String,String>());
		
		ServiceReference ref = bundleContext.getServiceReference(Red.class.getName());
		colorService = (Red) bundleContext.getService(ref);
		
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
		System.out.println("colorRed: " + message + ".");
	}
}