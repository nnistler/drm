package sp.drm.interfaces;

public interface DependencyResolver {
	<T> T getService(Class<T> clazz);
}