import java.util.*;

// "static void main" must be defined in a public class.
public class MinimumCost{
    public static void main(String[] args) {

        int edges[][] = new int[][]{{1, 4}, {4, 5}, {2, 3}};
        int newEdges[][] = new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};
       
        System.out.println(minimumCostToConnectAllNodes(6, edges, newEdges));
    
    }
    
    private static int minimumCostToConnectAllNodes(int n, int edges[][], int newEdges[][])
    {
        Arrays.sort(newEdges, (cost1, cost2) ->  cost1[2] - cost1[1]);
        
        final HashMap<Integer, Integer> parents = new HashMap<>();
                
        int result = 0;
        
        for (int i=1; i<n+1; i++)
        {
            parents.put(i, -1);
        }
        
        for (int edge[] : edges)
        {
            int ct1 = find(edge[0], parents);
            int ct2 = find(edge[1], parents);
            
            if (ct1 != ct2)
            {
                n--;
                parents.put(ct1, ct2);
            }
        }

        Arrays.sort(newEdges, (ct1, ct2) -> ct1[2] - ct2[2]);
        
        for (int newEdge[] : newEdges)
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
    
    private static int find(int element, Map<Integer, Integer> parents)
    {
        while(parents.get(element) != -1)
        {
            element = parents.get(element);
        }
        
        return element;
    }
    
    
}