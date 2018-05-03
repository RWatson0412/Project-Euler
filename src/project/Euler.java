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
		if(i == 8) return eigthAnswer();
		if(i == 9) return ninthAnswer();
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
	public static int eigthAnswer() { //Find highest product of 13 consecutive numbers.
		String bigNumber = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		long largestProduct = 0;
		List <Long> temp = new ArrayList <Long>();
		for(int i = 0; i < bigNumber.length() - 13; i++) {
			long product = 1;
			for(int k = i; k < i + 13; k++) {
				product *= Integer.parseInt(bigNumber.substring(k, k + 1));
			}
			if(product > largestProduct) largestProduct = product;
			if(product != 0) temp.add(product);
			product = 1;
			
	
		}
		System.out.println(Collections.max(temp));
		long l = Collections.max(temp);
		return (int) largestProduct;
	}
	public static int ninthAnswer() {
		
	}























}
