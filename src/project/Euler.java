//All problems taken from projecteuler.net

package project;

import java.util.Scanner;

public class Euler {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Which question would you like to have answered?");
		int i = scan.nextInt();
		System.out.println("The answer to question #" + i + " is " + getAnswer(i));
		if(getAnswer(i) == -1) {
			System.out.println("It looks like that question either doesn't exist or hasn't been answered yet.");
		}
		
	}

	public static int getAnswer(int i) {
		if(i == 1) return firstAnswer();
		
		return -1;
	}
	
	public static int firstAnswer() {
		return 0;
	}

}
