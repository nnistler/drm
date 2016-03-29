package sp.drm;

import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import sp.drm.interfaces.CalendarService;

public class ClockServiceActivator implements BundleActivator {

	public void start(BundleContext bc) throws Exception {
		String bundleName = (String) bc.getBundle().getHeaders().get(Constants.BUNDLE_NAME);
		System.out.println("Started " + bundleName);
		CalendarService service = new ClockService();
		Properties props = new Properties();
		bc.registerService(CalendarService.class.getName(), service, props); // Register service by interface
	}

	public void stop(BundleContext bc) throws Exception {
		String bundleName = (String) bc.getBundle().getHeaders().get(Constants.BUNDLE_NAME);
		System.out.println("Stopped " + bundleName);
	}
}