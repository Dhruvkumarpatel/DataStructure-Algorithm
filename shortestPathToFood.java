class Solution {
    
    public int getFood(char[][] grid) {
        
        if (grid == null || grid.length == 0)
        {
            return -1;
        }
        
        int result = 0;
        int dirs[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i=0; i<grid.length; i++)
        {
            for (int j=0; j<grid[0].length; j++)
            {
                
                if (grid[i][j] != '*')
                {
                    continue;
                }
                
                
                final Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                
                while (!queue.isEmpty())
                {
                    int size = queue.size();
                    
                    for (int k=0; k<size; k++)
                    {
                        int remove[] = queue.remove();
                        
                        for (int dir[] : dirs)
                        {
                            int ni = dir[0] + remove[0];
                            int nj = dir[1] + remove[1];
                            
                            if (ni>=0 && ni<rows && nj>=0 && nj<cols)
                            {
                                
                                if (grid[ni][nj] == '#')
                                {
                                    return result + 1;
                                }
                                
                                if (grid[ni][nj] == 'O')
                                {
                                     queue.add(new int[]{ni, nj});
                                     grid[ni][nj] = 'X';
                                }
                            }
                        }
                    }
                    
                    result += 1;
                }
                
            }
        }
        
        return -1;
    }
}