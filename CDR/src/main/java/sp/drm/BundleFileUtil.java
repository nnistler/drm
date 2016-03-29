package sp.drm;

import java.io.File;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class BundleFileUtil {
	public static final void readManifest(File jarFile) throws Exception {
		JarFile jar = null;
		InputStream is = null;
		try {
			jar = new JarFile(jarFile);
			JarEntry entry = jar.getJarEntry("META-INF/MANIFEST.MF");
			is = jar.getInputStream(entry);
			Manifest mf = new Manifest(is);
			System.out.println(mf.getMainAttributes());
		} finally {
			if (jar != null) {
				jar.close();
			}
			if (is != null) {
				is.close();
			}
		}
	}
}