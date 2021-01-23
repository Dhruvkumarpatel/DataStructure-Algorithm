class Solution {
    
    public int result = 0;
    
    public int maxLength(List<String> arr) {
        
        if (arr == null || arr.size() == 0)
        {
            return 0;
        }
        
        for (int i=0; i<arr.size(); i++)
        {
            concatStrings(arr, i, "");
        }
        
        return result;
    }
    
    public void concatStrings(List<String> arr, int currentIndex, String builder)
    {
        if (isCandidate(builder))
        {
            result = Math.max(result, builder.length());
        }
        
        for (int i = currentIndex; i<arr.size(); i++)
        {
            concatStrings(arr, i + 1, builder + arr.get(i));
        }
    }
    
    private boolean isCandidate(String input)
    {
        Set<Character> set = new HashSet<>();
        
        for (int i=0; i<input.length(); i++)
        {
            if (set.contains(input.charAt(i)))
            {
                return false;
            }
            
            set.add(input.charAt(i));
        }
        
        return true;
    }
    
}