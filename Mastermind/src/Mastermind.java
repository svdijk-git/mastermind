import java.util.Random;
import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		int spelerKansen = 10;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String userName = sc.nextLine();
		System.out.println("Username is: " + userName);
		Mastermind r = new Mastermind();
		r.setCode1();
		r.setCode2();
		r.spelerGok();
		r.setup();

	}

	// method voor random chars
	public void setCode1() {
		String chars = "abcdef";
		Random rnd = new Random();
		char c = chars.charAt(rnd.nextInt(chars.length()));
		System.out.println("Verborgencode " + c);
	}

	// NEW METHOD for RANDOM CHAR
	public void setCode2() {
		String chars = "abcdef";
		Random rnd = new Random();
		char p1 = chars.charAt(rnd.nextInt(chars.length()));
		char p2 = chars.charAt(rnd.nextInt(chars.length()));
		char p3 = chars.charAt(rnd.nextInt(chars.length()));
		char p4 = chars.charAt(rnd.nextInt(chars.length()));
		System.out.println("verborgencode: " + p1 + " " + p2 + " " + p3 + " " + p4 + "\n");
	}

	//nog een methode
	public char[] setup() {
		char[] code = new char[4];
		for (int i = 0; i < code.length; i++) {
			int randColor = (int) (Math.random() * 6) + 1;
			if (randColor == 1) {
				code[i] = 'a';
			} else if (randColor == 2) {
				code[i] = 'b';
			} else if (randColor == 3) {
				code[i] = 'c';
			} else if (randColor == 4) {
				code[i] = 'd';
			} else if (randColor == 5) {
				code[i] = 'e';
			} else if (randColor == 6) {
				code[i] = 'f';
			}
			System.out.println(code);
		}
		return code;
	}

	public void spelerGok() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Geef input 1");
		String input1 = sc.nextLine();
		System.out.println("Input 1= " + input1);
	}

}
