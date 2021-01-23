// "static void main" must be defined in a public class.
public class Main {
    
    /**
        Input: arr[] = {55, 23, 32, 46, 88}
        
        calculate the sum
        
        max_sum 10
        
        map == sum -> count
    **/
    public static void main(String[] args) {
        
        System.out.println(giveMaxSumOfSameDigitNums(new int[]{61,34,43}));
        
    }
    
    public static int digitSum(int n)
    {
        int sum = 0;
        
        while (n > 0)
        {
            int mod = n % 10;
            sum += mod;
            n = n/10;
        }
        
        return sum;
    }
    
    public static int giveMaxSumOfSameDigitNums(int input[])
    {   
        int result = -1;
        
        final Map<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<input.length; i++)
        {
            int digitSum = digitSum(input[i]);
            
            if (map.containsKey(digitSum))
            {
                result = Math.max(result, map.get(digitSum) + input[i]);
                map.put(digitSum, map.get(digitSum) > input[i] ? map.get(digitSum) : input[i]);
                continue;
            }
            
            map.put(digitSum, input[i]);
        }
    
        return result;
    }
    
}