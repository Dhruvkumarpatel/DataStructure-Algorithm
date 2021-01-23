/**
    
    create or modify the string without 3 identical characters
    
    input = "eedaaaaaaaaad"
    output = eedaad
    
    **/
    
    public static String stringwith3ConsicutiveCharacters(String input)
    {
        if (input == null || input.length() == 0)
        {
            return "";
        }
        
        final StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));
        sb.append(input.charAt(1));
        
        for (int i=2; i<input.length(); i++)
        {
            char current = input.charAt(i);
            
            if (current != input.charAt(i-1) || current != input.charAt(i-2))
            {
                sb.append(current);
            }
        }
        
        return sb.toString();
    }