// "static void main" must be defined in a public class.
import java.util.*;


public class TreasureIsland2 {
    public static void main(String[] args) {
        final char[][] map = new char[][]{{'S', 'O', 'O', 'S', 'S'}, {'D', 'O', 'D', 'O', 'D'}, {'O', 'O', 'O', 'O', 'X'},  {'X', 'D', 'D', 'O', 'O'}, {'X', 'D', 'D', 'D', 'O'}};
        
        System.out.println(findNumberOfSteps(map));
    }

    private static int findNumberOfSteps(char[][] map)
    {        
        int rows = map.length;
        int cols = map[0].length;
        
        if (map == null || (rows==0 && cols == 0))
        {
            return -1;
        }
        
        final Queue<int[]> queue = new LinkedList<int[]>();
        
        final int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
            {
                if (map[i][j] == 'S')
                {
                    queue.add(new int[]{i,j});
                    map[i][j] = 'D';
                }
            }
        }
        
        int steps = 0;
        
        while (!queue.isEmpty())
        {
            int size = queue.size();
            
            for (int i=0; i<size; i++)
            {
                int remove[] = queue.remove();
                
                for (int dir[] : directions)
                {
                    int ni = remove[0] + dir[0];
                    int nj = remove[1] + dir[1];
                    
                    if (ni>=0 && nj>=0 && ni<rows && nj<cols && map[ni][nj] == 'X')
                    {
                        steps++;
                        return steps;
                    }
                    
                    
                    if (ni>=0 && nj>=0 && ni<rows && nj<cols && map[ni][nj] != 'D')
                    {
                        queue.add(new int[]{ni, nj});
                        map[ni][nj] = 'D';
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
}