class FindTwoSum{
    public static void main(String[] args) {
        
        int nums[] = new int[]{20, 50, 40, 25, 30, 10};
        int target = 60;
        
        int output[] = twoSum(nums, target);
        
        System.out.print("[" + output[0] +","+ output[1] + "]");
    }
    
    private static  int[] twoSum(int[] nums, int target) {
        
        int max = Integer.MIN_VALUE;
        
        int output[] = new int[]{-1, -1};
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i =0; i<nums.length; i++)
        {
            int temp = target - nums[i];
            
            if (map.keySet().contains(temp))
            {
                if (nums[i] > max || nums[map.get(temp)] > max)
                {
                    output[0] = map.get(temp);
                    output[1] = i;
                    
                    max = Math.max(nums[i], nums[map.get(temp)]);
                }
            }
            
            map.put(nums[i], i);
        }
        
        
        return output;
    }
}