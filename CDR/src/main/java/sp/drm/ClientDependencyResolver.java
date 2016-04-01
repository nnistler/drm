package sp.drm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;
import org.osgi.framework.ServiceReference;

import sp.drm.interfaces.DependencyResolver;

public class ClientDependencyResolver implements DependencyResolver {
	private final BundleContext bc;

	public ClientDependencyResolver(BundleContext bc) {
		this.bc = bc;
	}

	@SuppressWarnings("unchecked")
	public <T> T getService(Class<T> clazz) {
		ServiceReference sref = bc.getServiceReference(clazz.getName());
		//if (sref.getProperty("hash").equals("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3")) {
			return (T) bc.getService(sref); // This is the service we are interested in
		//}
	}

	public void startBundle(File bundleFile) throws BundleException {
		if (!bundleFile.exists()) {
			throw new RuntimeException("Bundle file does not exist");
		}
		// Read Manifest file
		FileInputStream fis = null;
		try {
			BundleFileUtil.readManifest(bundleFile);
			fis = new FileInputStream(bundleFile);
			Bundle bundle = bc.installBundle("BundleName", fis);
			bundle.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
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