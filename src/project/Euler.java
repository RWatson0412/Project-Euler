//All problems taken from projecteuler.net

package project;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.*;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Euler {

	public static void main(String[] args) throws Exception {
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

	public static long getAnswer(int i) throws Exception {
		if(i == 1) return p1();
		if(i == 2) return p2();
		if(i == 3) return p3();
		if(i == 4) return p4();
		if(i == 5) return p5();
		if(i == 6) return p6();
		if(i == 7) return p7();
		if(i == 8) return p8();
		if(i == 9) return p9();
		if(i == 10) return p10();
		if(i == 11) return p11();
		if(i == 12) return p12();
		if(i == 13) return p13();
		if(i == 14) return p14();
		if(i == 15) return p15();
		if(i == 16) return p16();
		if(i == 17) return p17();
		if(i == 18) return p18();
		if(i == 19) return p19();
		if(i == 20) return p20();
		if(i == 21) return p21();
		if(i == 22) return p22();
//		if(i == 24) return p24();
		if(i == 25) return p25();
//		if(i == 26) return p26();
		return -1;
			
	}
	
	public static long p1() { //Find the sum of all multiples of 3 and 5 below 1000
		int sum = 0;
		for(int i = 0; i < 1000; i++) {
			if(i % 3 == 0 || i % 5 == 0) sum += i;
		}
		return sum;
	}
	public static long p2() { // Find the sum of even-valued terms under 4,000,000 in the Fibonnaci sequence.
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
	public static long p3() { //Find largest prime of 600851475143.
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
	public static long p4() { //Find largest palindrome made from the product of two 3-digit numbers.
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
	public static long p5() { //Find the smallest positive number that is evenly divisible by all numbers from 1 to 20.
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
	public static long p6() { //Find the difference between the sum of the squares of the first 100 natural numbers and the square of the sum.
		int squareOfSum = 0;
		int sumOfSquare = 0;
		for(int i = 1; i <= 100; i++) {
			squareOfSum += i;
			sumOfSquare += Math.pow(i, 2);
		}
		return (int) (Math.pow(squareOfSum, 2) - sumOfSquare);
	}
	public static long p7() { //Find 10001st prime
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
	public static long p8() { //Find highest product of 13 consecutive numbers.
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
	public static long p9() { //Find Pythagorean triple (natural numbers where a^2 + b^2 = c^2) where a+b+c=1000
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
	public static long p10() { //Find sum of all primes under 2,000,000
		long sum = 2;
		Tools tool = new Tools();
		for(int i = 1; i <= 2000000; i += 2) {
			if(tool.isPrime(i)) {
				sum += i;
			}
		}
		return sum;
	}
	public static long p11() { //Find greatest product of 4 adjacent numbers (can be horizontal, vertical, or diagonal)
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
	public static long p12() { //BROKEN Find first triangle number that has 500 divisors
		List<Long> lastNum = new ArrayList<Long>();
		lastNum.add((long) 1);
		lastNum.add((long) 3);
		for(long l = 2; l < Long.MAX_VALUE; l += lastNum.get(lastNum.size() - 1)) {
			List<Long> divisors = new ArrayList<Long>();
			for(long i = 1; i < l; i++) {
				if(l % i == 0) divisors.add(i);
			}
			if(divisors.size() >= 500) return l;
			System.out.println(l + " | " + divisors.size());
		}
		return 0;
	    }
	public static long p13() { //Find first 10 digits of the sum of the large number provided.
		BigInteger sum = BigInteger.ZERO;
		String input[] = {"37107287533902102798797998220837590246510135740250",
				"46376937677490009712648124896970078050417018260538",
				"74324986199524741059474233309513058123726617309629",
				"91942213363574161572522430563301811072406154908250",
				"23067588207539346171171980310421047513778063246676",
				"89261670696623633820136378418383684178734361726757",
				"28112879812849979408065481931592621691275889832738",
				"44274228917432520321923589422876796487670272189318",
				"47451445736001306439091167216856844588711603153276",
				"70386486105843025439939619828917593665686757934951",
				"62176457141856560629502157223196586755079324193331",
				"64906352462741904929101432445813822663347944758178",
				"92575867718337217661963751590579239728245598838407",
				"58203565325359399008402633568948830189458628227828",
				"80181199384826282014278194139940567587151170094390",
				"35398664372827112653829987240784473053190104293586",
				"86515506006295864861532075273371959191420517255829",
				"71693888707715466499115593487603532921714970056938",
				"54370070576826684624621495650076471787294438377604",
				"53282654108756828443191190634694037855217779295145",
				"36123272525000296071075082563815656710885258350721",
				"45876576172410976447339110607218265236877223636045",
				"17423706905851860660448207621209813287860733969412",
				"81142660418086830619328460811191061556940512689692",
				"51934325451728388641918047049293215058642563049483",
				"62467221648435076201727918039944693004732956340691",
				"15732444386908125794514089057706229429197107928209",
				"55037687525678773091862540744969844508330393682126",
				"18336384825330154686196124348767681297534375946515",
				"80386287592878490201521685554828717201219257766954",
				"78182833757993103614740356856449095527097864797581",
				"16726320100436897842553539920931837441497806860984",
				"48403098129077791799088218795327364475675590848030",
				"87086987551392711854517078544161852424320693150332",
				"59959406895756536782107074926966537676326235447210",
				"69793950679652694742597709739166693763042633987085",
				"41052684708299085211399427365734116182760315001271",
				"65378607361501080857009149939512557028198746004375",
				"35829035317434717326932123578154982629742552737307",
				"94953759765105305946966067683156574377167401875275",
				"88902802571733229619176668713819931811048770190271",
				"25267680276078003013678680992525463401061632866526",
				"36270218540497705585629946580636237993140746255962",
				"24074486908231174977792365466257246923322810917141",
				"91430288197103288597806669760892938638285025333403",
				"34413065578016127815921815005561868836468420090470",
				"23053081172816430487623791969842487255036638784583",
				"11487696932154902810424020138335124462181441773470",
				"63783299490636259666498587618221225225512486764533",
				"67720186971698544312419572409913959008952310058822",
				"95548255300263520781532296796249481641953868218774",
				"76085327132285723110424803456124867697064507995236",
				"37774242535411291684276865538926205024910326572967",
				"23701913275725675285653248258265463092207058596522",
				"29798860272258331913126375147341994889534765745501",
				"18495701454879288984856827726077713721403798879715",
				"38298203783031473527721580348144513491373226651381",
				"34829543829199918180278916522431027392251122869539",
				"40957953066405232632538044100059654939159879593635",
				"29746152185502371307642255121183693803580388584903",
				"41698116222072977186158236678424689157993532961922",
				"62467957194401269043877107275048102390895523597457",
				"23189706772547915061505504953922979530901129967519",
				"86188088225875314529584099251203829009407770775672",
				"11306739708304724483816533873502340845647058077308",
				"82959174767140363198008187129011875491310547126581",
				"97623331044818386269515456334926366572897563400500",
				"42846280183517070527831839425882145521227251250327",
				"55121603546981200581762165212827652751691296897789",
				"32238195734329339946437501907836945765883352399886",
				"75506164965184775180738168837861091527357929701337",
				"62177842752192623401942399639168044983993173312731",
				"32924185707147349566916674687634660915035914677504",
				"99518671430235219628894890102423325116913619626622",
				"73267460800591547471830798392868535206946944540724",
				"76841822524674417161514036427982273348055556214818",
				"97142617910342598647204516893989422179826088076852",
				"87783646182799346313767754307809363333018982642090",
				"10848802521674670883215120185883543223812876952786",
				"71329612474782464538636993009049310363619763878039",
				"62184073572399794223406235393808339651327408011116",
				"66627891981488087797941876876144230030984490851411",
				"60661826293682836764744779239180335110989069790714",
				"85786944089552990653640447425576083659976645795096",
				"66024396409905389607120198219976047599490197230297",
				"64913982680032973156037120041377903785566085089252",
				"16730939319872750275468906903707539413042652315011",
				"94809377245048795150954100921645863754710598436791",
				"78639167021187492431995700641917969777599028300699",
				"15368713711936614952811305876380278410754449733078",
				"40789923115535562561142322423255033685442488917353",
				"44889911501440648020369068063960672322193204149535",
				"41503128880339536053299340368006977710650566631954",
				"81234880673210146739058568557934581403627822703280",
				"82616570773948327592232845941706525094512325230608",
				"22918802058777319719839450180888072429661980811197",
				"77158542502016545090413245809786882778948721859617",
				"72107838435069186155435662884062257473692284509516",
				"20849603980134001723930671666823555245252804609722",
				"53503534226472524250874054075591789781264330331690"};

		for(int i = 0; i < input.length; i++) {
			BigInteger b = new BigInteger(input[i]);
			sum = sum.add(b);
		}
		System.out.println(sum.toString().substring(0, 10));
		return 0;
	}
	public static long p14() { //Find longest Collatz Chain (if n is even, next = n/2. if n is odd, next = 3n+1)
		long largest = 0;
		long longestSeq = 0;
		List <Long> collatzSeq = new ArrayList <Long>();
		for(long i = 1000000; i > 0; i--) {
//			System.out.println(i);
			long k = i;
			long seqSize = 0;
			collatzSeq.clear();
			collatzSeq.add(i);
			while(k != 1) {
				if(k % 2 == 0) {
					k /= 2;
					collatzSeq.add(k);
				} else {
					k = k * 3 + 1;
					collatzSeq.add(k);
				}
				seqSize++;
			}
//			System.out.println(collatzSeq);
			if(seqSize > longestSeq) {
				longestSeq = seqSize;
				largest = i;
			}
		}
		return largest;
	}
	public static long p15() { //Find number of paths from top right to bottom left of 20x20 grid (using formula (a)!/(a-b!)b!))
		String ans =  Tools.factorial(40).divide(Tools.factorial(40 - 20).multiply(Tools.factorial(20))).toString();
		long fin = Long.parseLong(ans);
		return fin;
	}
	public static long p16() { //Find sum of all digits in the result of 2^1000
		BigInteger power = BigInteger.valueOf(2);
		power = power.pow(1000);
		String result = power.toString();
		System.out.println(result.length());
		long sum = 0;
		for(int i = 0; i < result.length(); i++) {
			Character c = new Character(result.charAt(i));
			String temp = c.toString();
			int num = Integer.parseInt(temp);
			sum += num;
		}
		return sum;
	}
	public static long p17() { //BROKEN Find number of letters used to spell the numbers 1 through 1000 (not including spaces or hyphens)
		long ans = 0;
		for(int i = 0; i <= 1000; i++) {
			int k = i;
			if(Integer.toString(k).length() == 4) {
				int firstDigit = Integer.parseInt(Integer.toString(k).substring(0,1));
				String temp = Tools.thousandsToWord(firstDigit);
				ans += temp.length() - 1;
				k = Integer.parseInt(Integer.toString(k).substring(1));
			}
			if(Integer.toString(k).length() == 3) {
				int firstDigit = Integer.parseInt(Integer.toString(k).substring(0, 1));
				String temp = Tools.hundredsToWord(firstDigit);
				ans += temp.length() - 1;
				k = Integer.parseInt(Integer.toString(k).substring(1));
			}
			if(k < 20 && k > 9) {
				String temp = Tools.teensToWord(k);
				ans += temp.length();
				k = 0;
			}
			if(Integer.toString(k).length() == 2) {
				int firstDigit = Integer.parseInt(Integer.toString(k).substring(0, 1));
				String temp = Tools.tensToWord(firstDigit);
				ans += temp.length();
				k = Integer.parseInt(Integer.toString(k).substring(1));
			}
			String temp = Tools.onesToWord(k);
			ans += temp.length();
		}
		return ans;
	}
	public static long p18() {
		return -1;
	}
	public static long p19() {
		return -1;
	}
	public static long p20() { // Find sum of all digits in 100!
		BigInteger product = BigInteger.ONE;
		for(int i = 2; i <= 100; i++) {
			product = product.multiply(BigInteger.valueOf(i));
		}
		String ans = product.toString();
		long total = 0;
		for(int i = 0; i < ans.length() - 1; i++) {
			Character c = ans.charAt(i);
			String temp = c.toString();
			total += Integer.parseInt(temp);
		}
		return total;
	}
	public static long p21() {
		List<Integer> amicableNum = new ArrayList<Integer>();
		for(int i = 0; i < 10000; i++) {
			List<Integer> firstNum = new ArrayList<Integer>();
			int firstTotal = 0;
			for(int k = i; k > 0; k--) {
				if(i % k == 0) {
					firstNum.add(k);
					firstTotal += k;
				}
			}
			List<Integer> secondNum = new ArrayList<Integer>();
			int secondTotal = 0;
			for(int j = firstTotal; j > 0; j--) {
				if(firstTotal % j == 0) {
					secondNum.add(j);
					secondTotal += j;
				}
			}
			if(i  == secondTotal){
				amicableNum.add(i);
				amicableNum.add(firstTotal);
				System.out.println(amicableNum);
			}
		}
		return 0;
	}
	public static long p22() throws Exception{ //Sort p022_names.txt, find a names place, multiply by the name's value (A=1, z=24) and return sum of all.
//		File file = new File("C:\\Users\\Ryan-LTW\\Documents\\Personal Files\\p022_names.txt");
		File file = new File("E:\\Documents\\p022_names.txt");
		ArrayList<String> names = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		while((line = br.readLine()) != null) {
			String[] dataNames = line.split(",");
			for(String item : dataNames) {
				String newItem = item.substring(1, item.length() - 1);
				names.add(newItem);
			}
		}
		br.close();
		Collections.sort(names);
		long bigSum = 0;
		int mult = 1;
		for(int i = 0; i < names.size(); i++) {
			int x = valueOfName(names.get(i));
			mult = x * (i + 1);

            bigSum += mult;
        }

        System.out.println("Sum: " + bigSum);
		return bigSum;
    }
	public static int valueOfName(String s) {
        char[] ABC = {'1', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        char[] tempName = s.toCharArray();

        int sum = 0;
        for (char c : tempName) {
            for (int j = 0; j < ABC.length; j++) {
                if (c == ABC[j])
                    sum += j;
            }
        }
        return sum;
    }
	public static int p25() { //Find first index of first digit in Fibonnaci sequence to have 1000 digits
		List<String> nums = new ArrayList<String>();
		nums.add(Integer.toString(1));
		nums.add(Integer.toString(1));
		int size = nums.get(nums.size() - 1).length();
//		System.out.println(size);
		while(size < 1000) {
			String previous = nums.get(nums.size() - 1);
			String previouser = nums.get(nums.size() - 2);
			BigInteger lastNum = new BigInteger(previous);
			BigInteger lasterNum = new BigInteger(previouser);
			BigInteger nextNum = lastNum.add(lasterNum);
			String next = nextNum.toString();
			nums.add(next);
			size = nums.get(nums.size() - 1).length();
		}
		return nums.size();
	}
//	public static int p26() {
//		
//	}















}
