class subarraysWithKDistinct {
    public int subarraysWithKDistinct(int[] A, int K) {
        
        return findSubArrays(A, K) - findSubArrays(A, K -1);
        
    }
    
    private static int findSubArrays(int A[], int K)
    {
        int ans = 0;
        int left = 0;
        int right = 0;
        
        HashMap<Integer, Integer> uniqueElements = new HashMap<Integer, Integer>();
        
        while(right<A.length)
        {
            uniqueElements.put(A[right], uniqueElements.getOrDefault(A[right], 0) + 1);
                        
            while (uniqueElements.size() > K)
            {
                uniqueElements.put(A[left], uniqueElements.getOrDefault(A[left], 0) - 1);
                
                if (uniqueElements.get(A[left]) == 0)
                {
                    uniqueElements.remove(A[left]);
                }
                
                left++;
            }
            
            ans += right - left + 1;
            
            right++;
        }

        
        return ans;
    }
}