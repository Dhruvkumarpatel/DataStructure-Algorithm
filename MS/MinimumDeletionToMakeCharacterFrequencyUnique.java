class Solution {
    public int minDeletions(String s) {
        
        if (s == null || s.length() == 0)
        {
            return 0;
        }
        
        final Map<Character, String> characterToCount = new HashMap<>();
        
        for (int i=0; i<s.length(); i++)
        {
            characterToCount.put(s.charAt(i), characterToCount.getOrDefault(s.charAt(i), "") + s.charAt(i));
        }

        final Queue<String> maxHeap = new PriorityQueue<>((a,b) -> b.length() - a.length());

        for (String value : characterToCount.values())
        {
            maxHeap.add(value);
        }
        
        
        
        
        int result = 0;
        
        while (!maxHeap.isEmpty())
        {
            String top = maxHeap.poll();
            
            int length = maxHeap.isEmpty() ? 0 : maxHeap.peek().length();
            
            if (top.length() == length)
            {
                result++;
                
                if (top.length() > 1)
                {
                    maxHeap.add(top.substring(0, top.length() - 1));
                }
            }
        }
        
        return result;
    }
}