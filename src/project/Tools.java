package project;

import java.math.BigInteger;

public class Tools {

	public Tools() {
		// TODO Auto-generated constructor stub
	}

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
		switch(n) {
		case 1 : return "one";
		case 2 : return "two";
		case 3 : return "three";
		case 4 : return "four";
		case 5 : return "five";
		case 6 : return "six";
		case 7 : return "seven";
		case 8 : return "eight";
		case 9 : return "nine";
		}
		return "";
	}
	
	public static String tensToWord(int n) {
		switch(n) {
		case 1 : return "ten";
		case 2 : return "twenty";
		case 3 : return "thirty";
		case 4 : return "forty";
		case 5 : return "fifty";
		case 6 : return "sixty";
		case 7 : return "seventy";
		case 8 : return "eighty";
		case 9 : return "ninty";
		}
		return "";
	}
	
	public static String hundredsToWord(int n) {
		switch(n) {
		case 1 : return "one hundred";
		case 2 : return "two hundred";
		case 3 : return "three hundred";
		case 4 : return "four hundred";
		case 5 : return "five hundred";
		case 6 : return "six hundred";
		case 7 : return "seven hundred";
		case 8 : return "eight hundred";
		case 9 : return "nine hundred";
		}
		return "";
	}
	
	public static String thousandsToWord(int n) {
		switch(n) {
		case 1 : return "one thousand";
		case 2 : return "two thousand";
		case 3 : return "three thousand";
		case 4 : return "four thousand";
		case 5 : return "five thousand";
		case 6 : return "six thousand";
		case 7 : return "seven thousand";
		case 8 : return "eight thousand";
		case 9 : return "nine thousand";
		}
		return "";
	}
}
