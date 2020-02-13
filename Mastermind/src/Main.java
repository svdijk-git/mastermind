// Gevonden voorbeeld code 

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Mastermind! Your goal is to correctly guess a random sequence "
				+ "of four pegs that can be six colors, which are red, cyan, "
				+ "yellow, green, black, and white. You have 10 guesses, "
				+ "and will receive feedback after each guess. Good luck!");
		int numGuesses = 10;
		Scanner sc = new Scanner(System.in);
		while (true) {
			char[] code = setup(); // generates a random code
			for (int i = numGuesses; i > 0; i--) { // basic game loop
				System.out.println("You have " + i + " guesses remaining. The colors are red, cyan, yellow, green, black, and white");
				char[] playerGuess = new char[code.length];
				for (int j = 0; j < code.length; j++) {
					if (i == numGuesses && j == 0) // only prints 1st time
						System.out.println("Type 'r' for red, 'c' for cyan, 'y' for yellow, "
								+ "'g' for green, 'b' for black, or 'w' for white.");
					System.out.println("Please input your guess for color #" + (j + 1) + ".");
				  String myInput = sc.nextLine();
          playerGuess[j] = myInput.charAt(0);
        

          // take in the players input as a char. Scanner and a method for checking
					// if an input is valid have been created, although checkInput() is not complete.
				}
				if (checkGuess(code, playerGuess)) {
					System.out.println("You have won!"); // guessed code correct
					System.exit(0); // stops the program
				} else {
					int correctCount = 0; // number of pegs with correct color and position
					int colorCount = 0; // number of pegs with correct color, but not correct position
					boolean[] checked = new boolean[code.length]; // array that represents which pegs have been checked
					for (int j = 0; j < code.length; j++) {
						if (playerGuess[j] == code[j]) // check chars in both code and playerGuess are the same
							correctCount++;
						else {
							for (int k = j; k < code.length; k++) {
								if (k != j && !checked[k] && playerGuess[k] == code[j]) {
									checked[k] = true;
									colorCount++;
									break;
								}
							}
						}
					}
					System.out.println(correctCount + " of your pegs had the correct position and color.");
					System.out.println(colorCount + " of your pegs has the correct color, but not the correct position.");
				}
			}
			System.out.println("You have failed! Try again?");
			// doing it in the same way as last time, take in whether the player wants to play the game
			// again, and stop the program if they dont.
		}
	}

	public static char[] setup() {
		char[] code = new char[4];
		for (int i = 0; i < code.length; i++) {
			int randColor = (int) (Math.random() * 6) + 1;
			if (randColor == 1) {
				code[i] = 'r';
			} else if (randColor == 2) {
				code[i] = 'c';
			} else if (randColor == 3) {
				code[i] = 'y';
			} else if (randColor == 4) {
				code[i] = 'g';
			} else if (randColor == 5) {
				code[i] = 'b';
			} else if (randColor == 6) {
				code[i] = 'w';
			}
		}
		return code;
	}

	public static boolean checkInput(char c) {
		if(c == 'c' || c == 'b' || c == 'y' || c == 'g' || c == 'w' || c == 'r'){
      return true;
    } return false;// check and see if a char is either c,b,y,g,w, or r.
	}

	public static boolean checkGuess(char[] code, char[] guess) { 
   for(int i = 0; i < 4; i++){
     if(code[i] != guess[i]){
       return false;
     }
   }
  return true; 
		// check and see whether the code and the guess are equal
	}

}