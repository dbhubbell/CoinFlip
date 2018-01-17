package david.hubbell;

import java.util.Random;

public class Coin implements Tossable {
	private static Random random = new Random();

	public TossValue toss(){
		return (Coin.random.nextBoolean()) ? TossValue.HEADS : TossValue.TAILS;
	}
}

