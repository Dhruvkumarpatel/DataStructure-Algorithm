// "static void main" must be defined in a public class.
public class findMaximumOfMinimumAltitude {
    public static void main(String[] args) {
        int grid[][] = new int[][]{{6,7,8}, {5, 4, 2}, {8,7,6}};
        
        System.out.println(findMaximumOfMinimumAltitude(grid));
        
        /**
        
        Input:
[[1, 2, 3]
 [4, 5, 1]]

Output: 4
Explanation:
Possible paths:
1-> 2 -> 3 -> 1
1-> 2 -> 5 -> 1
1-> 4 -> 5 -> 1
So min of all the paths = [2, 2, 4]. Note that we don't include the first and final entry.
Return the max of that, so 4.
        */
        
        
    }
    
    private static int findMaximumOfMinimumAltitude(int grid[][])
    {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int dp[][] = new int[rows][cols];
        
        for (int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
               if (i == 0 && j > 1)
               {
                   dp[i][j] = Math.min(grid[i][j], dp[i][j-1]);
               }
               else if (j==0 && i > 1)
               {
                   dp[i][j] = Math.min(grid[i][j], dp[i-1][j]);
               }
               else if (i != 0 && j != 0 && (i != rows -1 || j != cols -1))
               {
                   int min1 = Math.min(grid[i][j] , dp[i-1][j]);
                   int min2 = Math.min(grid[i][j] , dp[i][j-1]);
                   
                   dp[i][j] = Math.max(min1, min2);
               }
               else
               {
                   dp[i][j] = grid[i][j];
               }
            }
        }
        
        return Math.max(dp[rows-1][cols-2], dp[rows-2][cols-1]);
    }
}