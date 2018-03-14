package david.hubbell;

/**
 * This interface defines the basic operations we'd like a graph to be
 * able to perform for us without being too specific about anything.
 *
 * @param <T> The Type of Object we'd like to represent in graph form.
 *
 * @author David Hubbell
 */
public interface UpdatableGraph<T> {
	void update(T type);
	void print();
}
