package david.hubbell;

/**
 * This interface declares the methods we'd like to see from
 * an object we consider "tossable".  Mainly we'd just like to
 * pretend we threw something in the air to see how it lands.
 *
 * The great thing is that if we ever decide to represent tossing
 * other things, like dice, grenades, or cookies, we could use a
 * common interface for dealing will everything!
 *
 * @author David Hubbell
 */
public interface Tossable<T> {
	/**
	 * Give something a toss!  Returns a value of your specification.
	 *
	 * @return A value of Type T.
	 */
	T toss();
}