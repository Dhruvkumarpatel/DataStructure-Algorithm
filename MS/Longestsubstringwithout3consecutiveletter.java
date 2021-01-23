    
    /**
    
    Input: "aabbaabbaabbaa"
Output: "aabbaa"
    
    **/
    
    private static String longestSubstringWithout3consesutiveletter(String input)
    {
        if (input == null || input.length() == 0)
        {
            return "";
        }
        
        int start = 0;
        int end = 0;
        
        int max_length = 0;
        
        int left = 0;
        
        int count = 1;
        char prev = input.charAt(0);
        
        int right = 1;
        
        while (right < input.length())
        {
            char current = input.charAt(right);
            
            if (current == prev)
            {
                count++;
            }
            else
            {
                count = 1;
                prev = current;
            }
            
            if (count % 3 == 0 && (right - left + 1) >= max_length)
            {
                start = left;
                end = right - 1;
                
                left = right + 1;
            }
            
            right++;
        }
        
        return end == 0 ? input : input.substring(start, end + 1);
    }