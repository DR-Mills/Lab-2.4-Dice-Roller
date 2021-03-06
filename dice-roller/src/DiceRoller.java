/*
Task: Create an application that simulates dice rolling.
What will the application do?
* Ask the user to enter the number of sides for a pair of dice.
* Prompt the user to roll the dice.
* ?Roll? two n-sided dice, display the results of each, and then ask the user if
he/she wants to roll the dice again.

Build Specifications
1. Define a static method named generateRandomDieRoll. It has a parameter that
specifies the number of sides on a die and returns a random number between 1
and that number. Call this method for each die that is rolled.
2. Experiment with different Random number generators?start with the random()
method of the Math class but also explore Java?s Random class.

Extended Challenges:
* Display special messages for craps, snake eyes, and box cars.
* Break the code up into more methods!

*/

import java.util.Random;
import java.util.Scanner;

public class DiceRoller {
	
	static StringBuffer diceComboMsg = new StringBuffer();
	static Random randomNumGen = new Random();

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		int die1 = 0;
		int die2 = 0;
		int diceTotal = 0;
		boolean rollAgain = true;
		String welcomeMsg = "Welcome to the Grand Circus Dice Game!\n" + "Enter the number of sides your dice should have: ";
		
		System.out.print(welcomeMsg);
		int dieSides = scnr.nextInt();

		while (rollAgain) {

			die1 = generateRandomDieRoll(dieSides);
			die2 = generateRandomDieRoll(dieSides);
			diceTotal = die1 + die2;
			whatIsDiceComboNickname(diceTotal);

			System.out.println("\nRoll Result: ");
			System.out.println(die1);
			System.out.println(die2);
			System.out.println("Total is: " + diceTotal + diceComboMsg);

			System.out.print("\nRoll again? (y/n): ");
			String userKeepsGoing = scnr.next();
			
			diceComboMsg.delete(0, diceComboMsg.length());
			
			rollAgain = userKeepsGoing.equalsIgnoreCase("y");
		}
		scnr.close();
	}

	// Methods

	// generates and returns a random number between 1 and n
	static int generateRandomDieRoll(int n) {
		return randomNumGen.nextInt(n) + 1;
	}

	// sets the diceComboMsg based on the case value of parameter (int a)
	static void whatIsDiceComboNickname(int a) {
		switch (a) {
		case 2:
			diceComboMsg.append(", AKA 'Snake Eyes' (or 'craps' if you were playing craps and it was your first roll).");
			break;
		case 3:
			diceComboMsg.append(", AKA 'Ace Caught a Deuce' (or 'craps' if you were playing craps and it was your first roll).");
			break;
		case 7:
			diceComboMsg.append(", AKA 'Big Red'.");
			break;
		case 11:
			diceComboMsg.append(", AKA 'Six Five no Jive' or simply 'Yo'.");
			break;
		case 12:
			diceComboMsg.append(", AKA 'Box Cars' or 'Midnight' (or 'craps' if you were playing craps and it was your first roll).");
			break;
		}
	}
}
