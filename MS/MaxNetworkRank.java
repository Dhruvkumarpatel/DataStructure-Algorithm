   /**
    Time complexity - O(n) + O(nlong) overall O(nlogn)
    Space Complexity - O(n)
    **/
    private static int maxNetwrokRank(int A[], int B[])
    {   
        final Map<Integer, Integer> nodeToConnections = new HashMap<>();
        
        int j = 0;
        
        for (int i=0; i<A.length; i++)
        {
                nodeToConnections.put(A[i], nodeToConnections.getOrDefault(A[i], 0) + 2);
                j++;
        }
        
        final Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        heap.addAll(nodeToConnections.entrySet());
        
        return heap.poll().getValue();
    }