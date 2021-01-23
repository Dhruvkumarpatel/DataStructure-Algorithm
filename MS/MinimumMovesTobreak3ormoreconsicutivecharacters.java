 /**
    
    Min Moves to Make String Without 3 Identical Consecutive Letters
    N = 3.
    input = baaab ans = 1
    
    
    **/
    private static int minMovesToBreakThreeConsicutiveCharacters(String input)
    {
        if (input == null || input.length() ==0)
        {
            return 0;
        }
        
        int ans = 0;
        char prev = input.charAt(0);
        
        int count = 1;
        
        for (int i=1; i<input.length(); i++)
        {
            char current = input.charAt(i);
            
            if (current == prev)
            {
                count++;
            }
            else
            {
                prev = current;
                count = 1;
            }
            
            if (count == 3)
            {
                ans += count / 3;
                count = 0;
            }
        }
        
        return ans;
    }