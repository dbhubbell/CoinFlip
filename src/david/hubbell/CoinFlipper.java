package david.hubbell;

import java.util.Scanner;

/**
 * {@link CoinFlipper} is the entry point for the Coin Flip project.
 * In here, you'll find the main method and various supporting methods
 * for gathering some input from the user, running the simulation, and
 * printing the outcome of that simulation.
 *
 * @author David Hubbell
 */
public class CoinFlipper {
	private static Scanner scanner = new Scanner(System.in);
	private static boolean running = true;

	/**
	 * This method asks the user how many coin tosses they'd like to simulate.
	 * It validates whatever the user inputs, so if they entered anything other
	 * than a int, they'll be prompted to try again and given a stern frowny face.
	 *
	 * @param retry     A <code>True</code> value means this is the first time
	 *                  we're running this method.  A <code>False</code> value,
	 *                  on the other hand, means the user gave us garbage and we'd
	 *                  really rather they try again and do better at following
	 *                  instructions.
	 *
	 * @return          Returns and int value representing the number of time the
	 *                  user would like to simulate tossing a {@link Coin}
	 */
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

	/**
	 * Once is never enough!  This prompts the user with a y/n question
	 * as to whether they'd like to run the simulation again.
	 * If they enter "Y" or "y", then we head back to the beginning and
	 * start over.  Anything else and we assume they meant "n".
	 */
	private static void promptToRunAgain() {
    	System.out.print("Do you want to run again? (y/n) : ");
    	String response = scanner.nextLine().toLowerCase();
    	running = (response.equals("y"));
    }

	/**
	 * <b>This is where it all begins!</b>
	 * The main method contains the program loop in which we model out the
	 * process of querying the user for how many coin tosses to simulate,
	 * running the simulation, and rendering the results.
	 *
	 * @param args      Command line arguments passed in.... We don't care
	 *                  about these right now.  Perhaps in the future we can
	 *                  create some command line options to circumvent the
	 *                  prompt and take the number of flips directly as an
	 *                  argument.
	 */
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
