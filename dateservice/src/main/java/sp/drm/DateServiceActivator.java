package sp.drm;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import sp.drm.interfaces.CalendarService;
import sp.drm.interfaces.DependencyResolver;

public class DateServiceActivator implements BundleActivator {
	public void start(BundleContext bc) throws Exception {
		String bundleName = (String) bc.getBundle().getHeaders().get(Constants.BUNDLE_NAME);
		System.out.println("Started " + bundleName);
		Object obj = bc.getService(bc.getServiceReference(DependencyResolver.class.getName()));
		System.out.println(obj.getClass().getName());
		DependencyResolver cdr = (DependencyResolver) obj;
		final CalendarService clock = cdr.getService(CalendarService.class);
		Thread t = new Thread(new Runnable() {
			public void run() {
				DateService service = new DateService(clock);
				while (!Thread.interrupted()) {
					System.out.println(service.getDateString());
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						break; // kill loop
					}
				}
			}
		});
		t.start();
	}

	public void stop(BundleContext bc) throws Exception {
		String bundleName = (String) bc.getBundle().getHeaders().get(Constants.BUNDLE_NAME);
		System.out.println("Stopped " + bundleName);
	}
}