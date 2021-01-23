 /**
    
     "baaabbabbb"
    
        String which does not contains 3 consecutive characters.
    
    **/
    private static String findLongestSemiAlternativesubstring(String input)
    {
        if (input == null || input.length() == 0)
        {
            return "";
        }
        
        int left = 0;
        int right = 0;
        
        int result = 0;
        
        int consicutiveCharsCount = 1;
            
        char prev = input.charAt(right);
        
        right++;
        
        int start = 0;
        int end = 0;
        
        while(right < input.length())
        {
            char current = input.charAt(right);
            
            if (current != prev)
            {
                right++;
                prev = current;
                consicutiveCharsCount = 1;
                continue;
            }
            
            consicutiveCharsCount++;
            
            if (consicutiveCharsCount % 3 == 0)
            {
                start = left;
                end = right - 1;
                result = Math.max(result, right - left);
                left = right - 1;
                consicutiveCharsCount = 2;
                
            }
            
            right++;
        }
        
        return input.substring(start, end+1);
        
    }