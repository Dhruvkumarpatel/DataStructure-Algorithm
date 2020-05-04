class mergeTowIntervals {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int rows = intervals.length;
        
        if (rows == 0)
        {
            return new int[][]{};
        }
        
        int cols = intervals[0].length;
        
        LinkedList<int[]> result = new LinkedList<>();
        
        for (int interval[] : intervals)
        {
            if (result.isEmpty() || result.getLast()[1] < interval[0])
            {
                result.add(interval);
            }
            else
            {
               result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        
        int output[][] = new int[result.size()][];
            
        return result.toArray(output);
    }
}