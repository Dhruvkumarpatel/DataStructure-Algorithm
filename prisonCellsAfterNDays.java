class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        
        List<String> savedResult = new ArrayList<>();
        
        int[] result = new int[cells.length];
        
        int i = 0;
        
        while(i<=N - 1)
        {
                int j = 1;
                result  = new int[cells.length];
            
                String temp = "";
                
                while (j < cells.length - 1)
                {
                    if (cells[j-1] == cells[j+1])
                    {
                        result[j] = 1;
                    }
                    else
                    {
                        result[j] = 0;
                    }
                 
                    j++;
                    
                    temp += result[j-1] + result[j];
                }
             i++;
            cells = result;
            
            
                
            if (savedResult.contains(temp))
            {
               i = i -1;
               int math = N % i;
                
               math = (math == 0) ? savedResult.size() - 1: math - 1;
                
               String output = "0" + savedResult.get(math) + "0";
                
               int array[] = new int[output.length()];
               
               for (int k=0; k<output.length(); k++)
               {
                   array[k] = Integer.parseInt(output.valueOf(output.charAt(k)));
               }
                
               return array; 
            }
            else
            {
                 savedResult.add(temp);
            }
        }
         
        return cells;
    }
    
}