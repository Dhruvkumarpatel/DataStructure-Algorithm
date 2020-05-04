class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> A) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < A.size(); i++) {
            adj.get(A.get(i).get(0)).add(A.get(i).get(1));
            adj.get(A.get(i).get(1)).add(A.get(i).get(0));
        }
        int[] timer = new int[1];
        boolean[] visited = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        int[] low = new int[n];
        tarjan(adj, -1, 0, timer, visited, res, low);
        return res;
    }
    
    public void tarjan(List<List<Integer>> adj, int parent, int node, int[] timer, boolean[] visited, List<List<Integer>> res, int[] low) {
        visited[node] = true;
        low[node] = timer[0]++;
        int cur_t = low[node];

        for(int nei : adj.get(node)) {
            if(nei == parent) continue;
            if(!visited[nei]) tarjan(adj, node, nei, timer, visited, res, low);
            low[node] = Math.min(low[node], low[nei]);
            if(cur_t < low[nei]) res.add(Arrays.asList(node, nei));
        }
    }
}