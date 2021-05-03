import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
class Solution {
    public static class UnionFind<T> {
        // WRITE YOUR BRILLIANT CODE HERE
        private HashMap<T, T> f = new HashMap<>();
        public T find(T x) {
            T y = f.getOrDefault(x, x);
            if (y != x) {
                y = find(y);
                f.put(x, y);
            }
            return y;
        }
        public void union(T x, T y) {
            f.put(find(x), find(y));
        }
    }
    public static int minCostToConnectNodes(int n, List<List<Integer>> edges, List<List<Integer>> newEdges) {
        UnionFind<Integer> trees = new UnionFind<>();
        for (List<Integer> uv : edges)
            trees.union(uv.get(0), uv.get(1));
        int cost = 0;
        newEdges.sort(Comparator.comparingInt(e -> e.get(2)));
        for (List<Integer> uvc : newEdges) {
            int s = trees.find(uvc.get(0));
            int t = trees.find(uvc.get(1));
            if (s == t)
                continue;
            cost += uvc.get(2);
            trees.union(s, t);
        }
        return cost;
    }
}