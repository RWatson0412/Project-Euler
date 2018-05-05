package project;

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

}
