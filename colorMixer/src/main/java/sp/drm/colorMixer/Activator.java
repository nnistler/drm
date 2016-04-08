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
	private ColorIF c1 = null;
	private ColorIF c2 = null;
	private ColorIF c3 = null;
	
	public void start(BundleContext bundleContext) throws Exception {
		Activator.bundleContext = bundleContext;
		log("started");
		
		bundleContext.registerService(
				ColorMixer.class.getName(),new ColorFactory(),new Hashtable<String,String>());
		bundleContext.registerService(
				ColorIF.class.getName(),new BlueFactory(),new Hashtable<String,String>());
		bundleContext.registerService(
				ColorIF.class.getName(),new GreenFactory(),new Hashtable<String,String>());
		bundleContext.registerService(
				ColorIF.class.getName(),new RedFactory(),new Hashtable<String,String>());
		
		ServiceReference[] refs = bundleContext.getServiceReferences(ColorIF.class.getName(),null);
		
		ServiceReference ref = bundleContext.getServiceReference(ColorMixer.class.getName());
		mixer = (ColorMixer) bundleContext.getService(ref);
		
		for(int i = 0; i < refs.length; i++)
		{
			if(c1 == null) { c1 = (ColorIF) bundleContext.getService(refs[i]); }
			else if(c2 == null) { c2 = (ColorIF) bundleContext.getService(refs[i]); }
			else if(c3 == null) { c3 = (ColorIF) bundleContext.getService(refs[i]); }
		}
		
		if(mixer != null)
		{
			if(c1 != null && c2 != null && c3 != null)
			{
				mixer.mix(c1, c2);
			}
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