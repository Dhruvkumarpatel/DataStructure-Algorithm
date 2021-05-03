"""
Given a string of length n consisting of digits [0-9], count the number of ways the given
string can be split into prime numbers, each of which is in the range 2 to 100 inclusive.
Since the answer can be large, return the answer modulo 109 + 7. Note: A partition that 
contains numbers with leading zeroes will be invalid and the initial string does not contain
leading zeroes. Take for example the input string to be s = "11373", then this string can be
split into 6 different ways as [11, 37, 3), [113, 7, 3), [11, 3, 73), [11, 37, 3), (113, 73)
and [11, 373) where each one of them contains only prime numbers.

Input Format For Custom Testing
The first and only line contains the string, s.
Sample Case 0

Sample Input

For Custom Testing
3175

Sample Output Explanation
The 3 ways to split this string into prime numbers are (31, 7,5), (3, 17, 5), (317,5)
public static void main(String[] args) {
	PrimeNumber obj = new PrimeNumber();
	System.out.println(obj.findNumberOfWays("11373"));
	System.out.println(obj.findNumberOfWays("3175"));

}

public int findNumberOfWays(String input) {
	List<List<Integer>> ways = new ArrayList<>();
	List<Integer> results = new ArrayList<Integer>();
	findPermutations(input, results, ways);
	return ways.size();
}

public void findPermutations(String suffix, List<Integer> results, List<List<Integer>> resultSet) {
	
	if (suffix.length() == 0) {
		resultSet.add(new ArrayList<Integer>(results));
		System.out.println(results.toString());
		return;
	}

	for (int i = 0; i < suffix.length(); ++i) {
		String snumber = suffix.substring(0, i + 1);

		int numb = Integer.parseInt(snumber);
		boolean isPrime = isPrimeNumber(numb);
		if(isPrime){
			results.add(numb);
			findPermutations(suffix.substring(i + 1),	results, resultSet);
			results.remove(results.size()-1);
		}
	}

}

public boolean isPrimeNumber(int number) {
	if (map.contains(number)) {
		return true;
	}
	boolean isPrime = isPrime(number);
	if(isPrime) map.add(number);
	
	return isPrime;
}

 boolean isPrime(int n) {
	if(n <= 1)
		return false;
	if(n == 2)	// 2 is prime
		return true;
    //check if n is a multiple of 2
    if (n % 2 == 0)
    	return false;
    //if not, then just check the odds
    for(int i=3; i<=n/2; i=i+2) {
        if(n % i == 0)
            return false;
    }
    return true;
}
"""
"""
public static int stringPrime0(String inputString) {
        buildSeive();
        return (naiveRecursion(inputString, inputString.length()));
    }
 
    public static int naiveRecursion(String inputString, int index) {
        if (index == 0) {
            return 1;
        }
        int count = 0;
        for (int j = 1; j <= 6; j++) {
            if (index - j >= 0 && inputString.charAt(index - j) != '0' &&
            isPrime(Integer.parseInt(inputString.substring(index - j, index)))) {
                count += naiveRecursion(inputString, index - j);
                count %= MOD;
            }
        }
        return count;
private static int HIGH = 1000000;
    private static int MOD = 1000000007;
    private static boolean[] seive = new boolean[HIGH];
 
    public static void buildSeive() {
        Arrays.fill(seive, true);
        seive[0] = false;
        seive[1] = false;
        for (int i = 2; i < HIGH; i++) {
            if (seive[i]) {
                for (int j = 2; i * j < HIGH; j++) {
                    seive[i * j] = false;
                }
            }
        }
    }
 
    public static boolean isPrime(int num) {
        return seive[num];
}
"""
MOD = 1000000007
def checkPrime(number):     
	num = int(number)
	for i in range(2, int(num**0.5)): 
		if((num % i) == 0):
			return False
	return True  if num > 2 else False
def splitter(s):
	if s == "":
		return 0

	res = []
	
	for i in range(1,len(s)):
		start = s[:i]
		end = s[i:]
		subList = [start,end]
		f = True
		for num in subList:
			if checkPrime(num) is False:
				f = False
				break
		if f:
			res.append(subList)	
		for split in splitter(end):
			result = [start]
			result.extend(split)
			f = True
			for num in result:
				if checkPrime(num) is False:
					f = False
					break
			if f:
				res.append(result)
				
	return res
def RunSplitter(s):
	res = list(splitter(s))
	return len(res)

str = "3175713175"
combinations = RunSplitter(str)
print(combinations)