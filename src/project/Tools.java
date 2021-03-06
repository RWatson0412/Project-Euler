package project;

import java.math.BigInteger;

public class Tools {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	public boolean isPrime(long num) {
		if(num < 2) return false;
		if(num == 2) return true;
		if(num % 2 == 0) return false;
		for(int i = 3; i * i <= num; i +=2) {
			if(num % i == 0) return false;
		}
		return true;
	}
	public boolean isPalindrome(int num) {
		String pal = Integer.toString(num);
		for(int i = 0; i < pal.length()/2; i++) {
			if(pal.charAt(i) != pal.charAt(pal.length() - i - 1)) return false;
		}
		return true;
	}
	public String reverseString(String word) {
		String ans = "";
		for(int i = word.length() - 1; i >= 0; i--) {
			ans += word.charAt(i);
		}
		return ans;
	}
	public boolean isWhole(double x) {
		return(Math.ceil(x) == Math.floor(x));
	}
	public int nextInCollatz(int x) {
		if(x % 2 == 0) return x/2;
		return x * 3 + 1;
	}
	public static BigInteger factorial(int n) {
		if(n < 0){ 
			throw new IllegalArgumentException("Can not find the factorial of a negative number.");
		}
		BigInteger product = BigInteger.ONE;
		for(int i = 2; i <= n; i++) {
			product = product.multiply(BigInteger.valueOf(i));
		}
		return product;
	}
	public static String onesToWord(int n) {
		if(n == 0) return "";
		String[] ONES = {"one", "two", "three", "four","five","six","seven","eight","nine"};
		return ONES[n - 1];
	}
	public static String teensToWord(int n) {
		if(n == 0) return "";
		String[] TEENS = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		return TEENS[n - 10];
	}
	public static String tensToWord(int n) {
		if(n == 0 || n == 1) return "";
		String[] TENS = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninty"};
		return TENS[n - 2];
	}
	public static String hundredsToWord(int n) {
		if(n == 0) return "";
		String[] HUNDREDS = {"one hundred","two hundred","three hundred","four hundred","five hundred","six hundred","seven hundred","eight hundred","nine hundred"};
		return HUNDREDS[n - 1];
	}
	public static String thousandsToWord(int n) {
		if(n == 0) return "";
		String[] THOUSANDS = {"one thousand", "two thousand", "three thousand", "four thousand","five thousand","six thousand","seven thousand","eight thousand","nine thousand"};
		return THOUSANDS[n - 1];
	}
	public static boolean isAlpha(char c) {
		Character.toUpperCase(c);
		if(c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F' || c == 'G' || c == 'H' || c == 'I' || c == 'J' || c == 'K' || c == 'L' || c == 'M' || c == 'N' || c == 'O' || c == 'P' || c == 'Q' || c == 'R' || c == 'S' || c == 'T' || c == 'U' || c == 'V' || c == 'W' || c == 'X' || c == 'Y' || c == 'Z') return true;
		return false;
	}



























}
