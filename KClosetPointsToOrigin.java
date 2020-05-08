class KClosetPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        
        if (points == null || points.length == 0 || K == 0)
        {
            return new int[][]{};
        }
        
        final Map<int[],Double> pointDistanceToOrigin = new HashMap<>();
        
        
        for (int point[] : points)
        {
            int dx = point[0] - 0;
            int dy = point[1] - 0;
            
            double distanceToOrigin = Math.sqrt((dx*dx) + (dy * dy));
            pointDistanceToOrigin.put(point, distanceToOrigin);
        }
        
        
        Queue<Map.Entry<int[],Double>> priorityQueue = new PriorityQueue<Map.Entry<int[],Double>>((a,b) -> a.getValue().compareTo(b.getValue()));
        
        priorityQueue.addAll(pointDistanceToOrigin.entrySet());
        
        int output[][] = new int[K][2];
        
        for (int i=0; i<K; i++)
        {
            output[i] = priorityQueue.poll().getKey();
        }
        
        return output;
    }
}