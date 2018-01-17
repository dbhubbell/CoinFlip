package david.hubbell;

import java.io.IOException;
import java.util.Scanner;

public class CoinFlipper {
	private static Scanner scanner = new Scanner(System.in);
	private static boolean running = true;

    private static int promptForNumberOfTosses(boolean retry) {
    	// Display contextual prompt to user
    	if(!retry) {
		    System.out.print("How many tosses? : ");
	    } else {
    		System.out.print("Please enter an integer value >=[\nHow many tosses? : ");
	    }

	    // return sanitized input
    	try {
    		return Integer.parseInt(scanner.nextLine());
	    } catch (NumberFormatException e) {
    		return promptForNumberOfTosses(true);
	    }
    }

    private static void promptToRunAgain() {
    	System.out.print("Do you want to run again? (y/n) : ");
    	String response = scanner.nextLine().toLowerCase();
    	running = (response.equals("y"));
    }

	public static void main(String[] args) {
    	while(running) {
		    int numTosses = promptForNumberOfTosses(false);
		    UpdatableGraph graph = new HorizontalCoinFlipHistogram();
		    for (int i = 0; i < numTosses; i++) {
			    graph.update(new Coin().toss());
		    }
		    graph.print();
		    promptToRunAgain();
	    }
	}
}
