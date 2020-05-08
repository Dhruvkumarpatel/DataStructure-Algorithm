import java.util.*;

// "static void main" must be defined in a public class.
public class MinimumCostToRepairEdges{
    public static void main(String[] args) {

        int edges[][] = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4,5}, {1,5}};
        int newEdges[][] = new int[][]{{1, 2, 12}, {3, 4, 30}, {1, 5, 8}};
       
        System.out.println(minimumCostToConnectAllNodes(5, edges, newEdges));
        
        
        /**
       Input: n = 5, edges = [[1, 2], [2, 3], [3, 4], [4, 5], [1, 5]], edgesToRepair = [[1, 2, 12], [3, 4, 30], [1, 5, 8]]
Output: 20
Explanation:
There are 3 connected components due to broken edges: [1], [2, 3] and [4, 5].
We can connect these components into a single component by repearing the edges between nodes 1 and 2, and nodes 1 and 5 at a minimum cost 12 + 8 = 20.
        */
    
    }
    
    private static int minimumCostToConnectAllNodes(int n, int edges[][], int edgesToRepair[][])
    {
        Arrays.sort(edgesToRepair, (e1, e2) ->  e1[2] - e2[2]);
        
        final HashMap<Integer, Integer> parents = new HashMap<>();
                
        int result = 0;
        
        for (int i=1; i<n+1; i++)
        {
            parents.put(i, -1);
        }
        
        for (int edge[] : edges)
        {
            if (isBroken(edge, edgesToRepair))
            {
                continue;
            }
            
            int ct1 = find(edge[0], parents);
            int ct2 = find(edge[1], parents);
            
            if (ct1 != ct2)
            {
                n--;
                parents.put(find(ct1, parents), find(ct2, parents));
            }
        }

        for (int newEdge[] : edgesToRepair)
        {
            if (n == 1)
                break;
            
            int ct1 = find(newEdge[0], parents);
            int ct2 = find(newEdge[1], parents);
            
            if (ct1 != ct2)
            {
                n--;
                parents.put(ct1, ct2);
                
                result += newEdge[2];
            }
        }
       
        return n ==1 ? result : -1;
    }
    
    
    private static boolean isBroken(int edge[], int edgesToRepair[][])
    {
        for (int e[] : edgesToRepair)
        {
            if (Arrays.equals(new int[]{e[0], e[1]}, edge))
            {
                return true;
            }
        }
        
        return false;
    }
    
    private static int find(int element, Map<Integer, Integer> parents)
    {
        while(parents.get(element) != -1)
        {
            element = parents.get(element);
        }
        
        return element;
    }
    
    
}