// "static void main" must be defined in a public class.
public class TreasureIsland {
    public static void main(String[] args) {
        final char[][] map = new char[][]{{'O', 'O', 'O', 'O'}, {'D', 'O', 'D', 'O'}, {'O', 'O', 'O', 'O'},  {'X', 'D', 'D', 'O'}};
        
        System.out.println(findNumberOfSteps(map));
    }
    
    private static int findNumberOfSteps(char[][] map)
    {
        int rows = map.length;
        int cols = map[0].length;
        
        if (map == null || (rows==0 && cols == 0))
        {
            return 0;
        }

        final Queue<int[]> queue = new LinkedList<int[]>();
        int steps = 0;
        
        queue.add(new int[] {0,0});
        
        final int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        boolean visited[][] = new boolean[rows][cols];
        visited[0][0] = true;
        
        while (!queue.isEmpty())
        {
            int size = queue.size();
            
            for (int i=0; i<size; i++)
            {
                int[] remove = queue.remove();
            
            for (int dir[] : directions)
            {
                int ni = dir[0] + remove[0];
                int nj = dir[1] + remove[1];
                
                if (ni>=0 && ni<rows && nj>=0 && nj<cols && map[ni][nj] == 'X')
                {
                    steps++;
                    return steps;
                }
                
                if (ni>=0 && ni<rows && nj>=0 && nj<cols && map[ni][nj] == 'O' && !visited[ni][nj])
                {
                    queue.add(new int[]{ni, nj});
                    visited[ni][nj] = true;
                }
            }
            }
            
            steps++;
            
            
        }
        
        return -1;
    }
}