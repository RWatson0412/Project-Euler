//All problems taken from projecteuler.net

package project;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
		if(i == 2) return secondAnswer();
		return -1;
	}
	
	public static int firstAnswer() { //Find the sum of all multiples of 3 and 5 below 1000
		int sum = 0;
		for(int i = 0; i < 1000; i++) {
			if(i % 3 == 0 || i % 5 == 0) sum += i;
		}
		return sum;
	}
	public static int secondAnswer() { // Find the sum of even-valued terms under 4,000,000 in the Fibonnaci sequence.
		int sum = 0;
		List<Integer> fib = new ArrayList<Integer>();
		fib.add(1);
		fib.add(2);
		int index = 2;
		int i = 0;
		while(i < 4000000) {
			i = (int) fib.get(index - 1) + (int) fib.get(index - 2);
			fib.add(i);
			index++;
		}
		fib.remove(fib.size()-1);
		for(int k = 0; k < fib.size(); k++) {
			if((int) fib.get(k) % 2 == 0) {
				sum += (int) fib.get(k);
			}
		}
		return sum;
	}
	public static int thirdAnswer() { //Find largest prime of 600851475143. UNSOLVED
		int ans = 0;
		List <Integer> primes = new ArrayList();
		BigInteger num = new BigInteger("600851475143");
		BigInteger i = new BigInteger("600851475143");
		return ans;
	}
	public static int fourthAnswer() { //Find largest palindrome made from the product of two 3-digit numbers.
		int ans = 0;
		return ans;
		
	}
	public boolean isPrime(int num) {
		if(num < 2) return false;
		if(num == 2) return true;
		if(num % 2 == 0) return false;
		for(int i = 3; i * i <= num; i += 2) {
			if(num % i == 0) return false;
		}
		return true;
	}
}
