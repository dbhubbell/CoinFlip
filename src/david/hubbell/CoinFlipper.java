package david.hubbell;

import java.util.Scanner;

public class CoinFlipper {
	private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	int numTosses = promptForNumberOfTosses(false);
	    for(int i = 0; i < numTosses; i++) {
	        System.out.println(new Coin().toss().toString());
        }
    }

    private static int promptForNumberOfTosses(boolean retry) {
    	if(!retry) {
		    System.out.print("How many tosses? : ");
	    } else {
    		System.out.print("Please enter an integer value >=[\nHow many tosses? : ");
	    }
    	String userInput = scanner.nextLine();
    	int input;
    	try {
    		input = Integer.parseInt(userInput);
	    } catch (NumberFormatException e) {
    		return promptForNumberOfTosses(true);
	    }

	    return input;
    }


}
