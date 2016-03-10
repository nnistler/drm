package sp.drm;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;

public class ClientDependencyResolver {
	private final BundleContext bc;

	public ClientDependencyResolver(BundleContext bc) {
		this.bc = bc;
	}

	public void startBundle(String bundleName) throws BundleException {
		//Bundle bundle = bc.installBundle(bundleName, inputStream);
		//bundle.start();
	}

	public void stopBundle(final Bundle bundle) throws BundleException {
		// Add the listener first, since the bundle may stop before the listener is added.
		bundle.getBundleContext().addBundleListener(new BundleListener() {
			public void bundleChanged(BundleEvent event) {
				if (event.getType() == BundleEvent.STOPPED) {
					try {
						bundle.uninstall();
					} catch (BundleException e) {
						// TODO What is the best way to handle this exception?
					}
				}
			}
		});
		// Now stop the bundle
		bundle.stop();
	}
}