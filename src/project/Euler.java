//All problems taken from projecteuler.net

package project;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.tools.Tool;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Euler {

	public static void main(String[] args) {
		Tools tool = new Tools();
		Scanner scan = new Scanner(System.in);
		System.out.println("Which question would you like to have answered?");
		int i = scan.nextInt();
		long startTime = System.nanoTime();
		System.out.println("The answer to question #" + i + " is " + getAnswer(i));
		if(getAnswer(i) == -1) {
			System.out.println("It looks like that question either doesn't exist or hasn't been answered yet.");
		}
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		double seconds = (double) totalTime / 1000000000.0;
		System.out.println("This program ran in " + seconds + " seconds.");
		
	}

	public static int getAnswer(int i) {
		if(i == 1) return firstAnswer();
		if(i == 2) return secondAnswer();
		if(i == 3) return (int) thirdAnswer();
		if(i == 4) return fourthAnswer();
		if(i == 5) return fifthAnswer();
		if(i == 6) return sixthAnswer();
		if(i == 7) return seventhAnswer();
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
	public static double thirdAnswer() { //Find largest prime of 600851475143.
		long num = 600851475143L;
		Tools tool = new Tools();
		List <Long> primeFactors = new ArrayList<Long>();
		for(long i = 3; i * i <= num; i += 2) {
			if(tool.isPrime(i) && num % i == 0) {
				primeFactors.add(i);
			}
		}
		return Collections.max(primeFactors);
		
	}
	public static int fourthAnswer() { //Find largest palindrome made from the product of two 3-digit numbers.
		Tools tool = new Tools();
		List<Integer> palList = new ArrayList<Integer>();
		for(int i = 999; i >= 0; i--) {
			for(int k = 999; k >= 0; k--) {
				if(tool.isPalindrome(i * k)) {
					palList.add(i * k);
				}
			}
		}
		return Collections.max(palList);
	}
	public static int fifthAnswer() { //Find the smallest positive number that is evenly divisible by all numbers from 1 to 20.
		int ans = 1;
		Tools tool = new Tools();
		for(int i = 0; i <= 20; i++) {
			if(tool.isPrime(i)) {
				System.out.println(i + " is prime.");
				ans *= i;
			}
		}
		return ans;
	}
	public static int sixthAnswer() { //Find the difference between the sum of the squares of the first 100 natural numbers and the square of the sum.
		int squareOfSum = 0;
		int sumOfSquare = 0;
		for(int i = 1; i <= 100; i++) {
			squareOfSum += i;
			sumOfSquare += Math.pow(i, 2);
		}
		return (int) (Math.pow(squareOfSum, 2) - sumOfSquare);
	}
	public static int seventhAnswer() { //Find 10001st prime
		int counter = 0;
		int i = 2;
		Tools test = new Tools();
		while(counter < 10001) {
			if(test.isPrime(i)) {
				counter++;
			}
			i++;
		}
		return i - 1;		
	}
	
























}
