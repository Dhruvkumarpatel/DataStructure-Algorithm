class NumberOfIslands{
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int numberOfIsland = 0;
        
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
            {
                if (grid[i][j] == '1')
                {
                    numberOfIsland++;
                    
                    grid[i][j] = '0';
                    
                    final Queue<int[]> queue = new LinkedList<int[]>();
                    
                    queue.add(new int[]{i,j});
                    
                    while (!queue.isEmpty())
                    {
                        int remove[] = queue.remove();
                        
                        int m = remove[0];
                        int n = remove[1];
                        
                        if (m>=0 && m<rows && n+1>=0 && n+1 < cols && grid[m][n+1] == '1')
                        {
                            queue.add(new int[]{m, n+1});
                            grid[m][n+1] = '0';
                        }
                        if (m>=0 && m<rows && n-1 >=0 && n-1 < cols && grid[m][n-1] == '1')
                        {
                            queue.add(new int[]{m, n-1});
                            grid[m][n-1] = '0';
                        }
                        if (m+1>=0 && m+1<rows && n>=0 && n<cols && grid[m+1][n] == '1')
                        {
                            queue.add(new int[]{m+1, n});
                            grid[m+1][n] = '0';
                        }
                        if (m-1>=0 && m-1<rows && n>=0 && n<cols && grid[m-1][n] == '1')
                        {
                            queue.add(new int[]{m-1, n});
                            grid[m-1][n] = '0';
                        }
                    }
                    
                }
            }
        }
        
        return numberOfIsland;
        
    }
}