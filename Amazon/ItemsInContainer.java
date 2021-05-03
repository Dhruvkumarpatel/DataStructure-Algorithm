import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class ItemsInContainer {
    public static List<Integer> numberOfItems(String s, List<List<Integer>> ranges) {
        int n = s.length();
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|')
                prefixSums.put(i, curSum);
            else
                curSum++;
        }
        int[] leftBounds = new int[n];
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|')
                last = i;
            leftBounds[i] = last;
        }
        int[] rightBounds = new int[n];
        last = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|')
                last = i;
            rightBounds[i] = last;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < ranges.size(); i++) {
            int start = rightBounds[ranges.get(i).get(0)];
            int end = leftBounds[ranges.get(i).get(1)];
            if (start != -1 && end != -1 && start < end)
                res.add(prefixSums.get(end) - prefixSums.get(start));
            else
                res.add(0);
        }
        return res;
    }
}
