// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(getPatternCount(";bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32"));
    }
    /**
    bc;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32
    
    
    **/
    private static int getPatternCount(String input)
    {
        if (input == null || input.length() == 0)
        {
            return 0;
        }
        
        String split[] = input.split(";");
        String pattern = split[0];
        
        if (pattern.isEmpty())
        {
            return 0;
        }
        
        System.out.println(pattern);
        
        String samples[] = split[1].split("\\|");
        
        int totalCount = 0;
        
        for (String sample : samples)
        {
            int count = 0;

            for (int i=0; i<=sample.length() - pattern.length(); i++)
            {
                final StringBuilder sb = new StringBuilder();
                sb.append(sample.substring(i, i + pattern.length()));
                
                System.out.println("substring:"+sb.toString());
                
                if (sb.toString().equals(pattern))
                {
                    System.out.println("pattern found");
                    count++;
                }
                
            }
            
            totalCount += count;
        }
        
        return totalCount;
    }
}