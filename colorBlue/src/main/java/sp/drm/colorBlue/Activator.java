package sp.drm.colorBlue;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceReference;

import sp.drm.colorBlue.BlueFactory;
import sp.drm.colorBlue.Blue;
import java.util.Hashtable;
import sp.drm.ServiceIF.ColorIF;

public class Activator implements BundleActivator {
	
	public static BundleContext bundleContext = null;
	private Blue colorService = null;
	
	public void start(BundleContext bundleContext) throws Exception {
		Activator.bundleContext = bundleContext;
		
		log("started");
		ServiceFactory serviceFactory = new BlueFactory();
		bundleContext.registerService(
				Blue.class.getName(),serviceFactory,new Hashtable<String,String>());
		
		ServiceReference ref = bundleContext.getServiceReference(Blue.class.getName());
		colorService = (Blue) bundleContext.getService(ref);
		
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
		System.out.println("colorBlue: " + message + ".");
	}
}