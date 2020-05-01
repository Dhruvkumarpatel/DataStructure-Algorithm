class ConnectCitiesWithMinimumCost {
    public int minimumCost(int N, int[][] connections) {
       
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        
        Map<Integer,Integer> parents = new HashMap<>();
        
        for (int i=1; i<N+1; i++)
        {
            parents.put(i, i);
        }
        
        int result = 0;
        
        
        for (int connection[] : connections)
        {
            int ct1 = Find(connection[0], parents);
            int ct2 = Find(connection[1], parents);
            
            if (ct1 != ct2)
            {
                result += connection[2];
                Union(ct1, ct2, parents);
                N--;
            }
        }
        
        
        return (N==1) ? result : -1;
    }
    
    private static int Find(int element, Map<Integer,Integer> parents)
    {
        int parent = parents.get(element);
        
        if (parent == element)
        {
            return parent;
        }
        
        return Find(parent, parents);
    }
    
    private static void Union(int element1, int element2, Map<Integer,Integer> parents)
    {   
         parents.put(Find(element1, parents), Find(element2, parents));
    }
}