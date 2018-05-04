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
		System.out.println(tool.isWhole(24));
		System.out.println(tool.isWhole(37));
		System.out.println(tool.isWhole((long) 24.4));
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

	public static long getAnswer(int i) {
		if(i == 1) return firstAnswer();
		if(i == 2) return secondAnswer();
		if(i == 3) return thirdAnswer();
		if(i == 4) return fourthAnswer();
		if(i == 5) return fifthAnswer();
		if(i == 6) return sixthAnswer();
		if(i == 7) return seventhAnswer();
		if(i == 8) return eigthAnswer();
		if(i == 9) return ninthAnswer();
		if(i == 10) return tenthAnswer();
		if(i == 11) return eleventhAnswer();
		if(i == 12) return twelfthAnswer();
		return -1;
			
	}
	
	public static long firstAnswer() { //Find the sum of all multiples of 3 and 5 below 1000
		int sum = 0;
		for(int i = 0; i < 1000; i++) {
			if(i % 3 == 0 || i % 5 == 0) sum += i;
		}
		return sum;
	}
	public static long secondAnswer() { // Find the sum of even-valued terms under 4,000,000 in the Fibonnaci sequence.
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
	public static long thirdAnswer() { //Find largest prime of 600851475143.
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
	public static long fourthAnswer() { //Find largest palindrome made from the product of two 3-digit numbers.
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
	public static long fifthAnswer() { //Find the smallest positive number that is evenly divisible by all numbers from 1 to 20.
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
	public static long sixthAnswer() { //Find the difference between the sum of the squares of the first 100 natural numbers and the square of the sum.
		int squareOfSum = 0;
		int sumOfSquare = 0;
		for(int i = 1; i <= 100; i++) {
			squareOfSum += i;
			sumOfSquare += Math.pow(i, 2);
		}
		return (int) (Math.pow(squareOfSum, 2) - sumOfSquare);
	}
	public static long seventhAnswer() { //Find 10001st prime
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
	public static long eigthAnswer() { //Find highest product of 13 consecutive numbers.
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
	public static long ninthAnswer() { //Find Pythagorean triple (natural numbers where a^2 + b^2 = c^2) where a+b+c=1000
		int sum = 1000;
		for(int a = 1; a <= sum / 3; a++) {
			for(int b = a + 1; b <= sum / 2; b++) {
				int c = sum - a - b;
				System.out.println(a + " | " + b + " | " + c);
				if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && a + b + c == 1000) {
					return a * b * c;
				}
			}
		}
		return 0;
	}
	public static long tenthAnswer() { //Find sum of all primes under 2,000,000
		long sum = 2;
		Tools tool = new Tools();
		for(int i = 1; i <= 2000000; i += 2) {
			if(tool.isPrime(i)) {
				sum += i;
			}
		}
		return sum;
	}
	public static long eleventhAnswer() { //Find greatest product of 4 adjacent numbers (can be horizontal, vertical, or diagonal)
		int grid [][] = {
				{8,02,22,97,38,15,00,40,00,75,04,05,07,78,52,12,50,77,91,8},
		        {49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48,04,56,62,00},
		        {81,49,31,73,55,79,14,29,93,71,40,67,53,88,30,03,49,13,36,65},
		        {52,70,95,23,04,60,11,42,69,24,68,56,01,32,56,71,37,02,36,91},
		        {22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80},
		        {24,47,32,60,99,03,45,02,44,75,33,53,78,36,84,20,35,17,12,50},
		        {32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70},
		        {67,26,20,68,02,62,12,20,95,63,94,39,63,8,40,91,66,49,94,21},
		        {24,55,58,05,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72},
		        {21,36,23,9,75,00,76,44,20,45,35,14,00,61,33,97,34,31,33,95},
		        {78,17,53,28,22,75,31,67,15,94,03,80,04,62,16,14,9,53,56,92},
		        {16,39,05,42,96,35,31,47,55,58,88,24,00,17,54,24,36,29,85,57},
		        {86,56,00,48,35,71,89,07,05,44,44,37,44,60,21,58,51,54,17,58},
		        {19,80,81,68,05,94,47,69,28,73,92,13,86,52,17,77,04,89,55,40},
		        {04,52,8,83,97,35,99,16,07,97,57,32,16,26,26,79,33,27,98,66},
		        {88,36,68,87,57,62,20,72,03,46,33,67,46,55,12,32,63,93,53,69},
		        {04,42,16,73,38,25,39,11,24,94,72,18,8,46,29,32,40,62,76,36},
		        {20,69,36,41,72,30,23,88,34,62,99,69,82,67,59,85,74,04,36,16},
		        {20,73,35,29,78,31,90,01,74,31,49,71,48,86,81,16,23,57,05,54},
		        {01,70,54,71,83,51,54,69,16,92,33,48,61,43,52,01,89,19,67,48}
		        };
		int highest = 0;
		//check diagonal (top left to bottom right)
		for(int i = 0; i < grid.length - 3; i++) {  
			for(int k = 0; k < grid.length - 3; k++) {
				int check = grid[i][k] * grid[i+1][k+1]* grid[i+2][k+2]* grid[i+3][k+3];
				if(check > highest) highest = check;
			}
		}
		//check diagonal (bottom left to top right)
		for(int i = 0; i < grid.length - 3; i++) { 
			for(int k = 3; k < grid.length; k++) {
				int check = grid[i][k] * grid[i+1][k-1] * grid[i+2][k-2] * grid[i+3][k-3];
				if(check > highest) highest = check;
			}
		}
		//check rows
		for(int i = 0; i < grid.length; i++) { 
			for(int k = 0; k < grid.length - 3; k++) {
				int check = grid[i][k] * grid[i][k+1] * grid[i][k+2] * grid[i][k+3];
				if(check > highest) highest = check;
			}
		}
		//check columns
		for(int i = 0; i < grid.length - 3; i++) { 
			for(int k = 0; k < grid.length; k++) {
				int check = grid[i][k] * grid[i+1][k] * grid[i+2][k] * grid[i+3][k];
				if(check > highest) highest = check;
			}
		}
		return highest;
	}
	public static long twelfthAnswer() {
		long triangleNumber = 0;
		boolean solved = false;
		List<Integer> divisors = new ArrayList <Integer>();
		int i = 0;
		while(!solved) {
			triangleNumber += i;
			for(int k = 1; k < triangleNumber / 2; k++) {
				if(triangleNumber / k ==) divisors.add(k);
				}
			if(divisors.size() >= 500) solved = true;
			i++;
			System.out.println(i + " | " + triangleNumber + " | " + divisors);
			}
		return triangleNumber;
		}
	
	






















}
