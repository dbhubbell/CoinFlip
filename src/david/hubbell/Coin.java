package david.hubbell;

import java.util.Random;

/**
 * The {@link Coin} class implements the {@link Tossable} interface
 * in order to simulate the tossing of a fair coin.  The result of
 * tossing a coin is going to be either a {@link TossValue#HEADS} or
 * {@link TossValue#TAILS}.
 *
 * It's up to anyone using this class to determine what they want to
 * do in response to either of those values.
 *
 * @author David Hubbell
 * @see TossValue
 * @see Tossable
 */
public class Coin implements Tossable {
	private static Random random = new Random();

	/**
	 * This method simulates a fair coin toss by obtaining a random
	 * boolean value using the {@link Random#nextBoolean()} method.
	 *
	 * @return Either a {@link TossValue#HEADS} or {@link TossValue#TAILS}
	 */
	public TossValue toss(){
		return (random.nextBoolean()) ? TossValue.HEADS : TossValue.TAILS;
	}
}

