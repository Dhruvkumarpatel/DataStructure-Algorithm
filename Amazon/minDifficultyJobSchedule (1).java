import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class minDifficultyJobSchedule {
    private static int dfs(List<Integer> jobDifficulty, int i, int d) {
        int n = jobDifficulty.size();
        if (d == 1) {
            return Collections.max(jobDifficulty.subList(i, n));
        }
        int res = Integer.MAX_VALUE;
        int maxInDivision = 0;
        for (int j = i; j < n - d + 1; j++) {
            maxInDivision = Math.max(maxInDivision, jobDifficulty.get(j));
            res = Math.min(res, maxInDivision + dfs(jobDifficulty, j + 1, d - 1));
        }
        return res;
    }
    public static int minDifficulty(List<Integer> jobDifficulty, int d) {
        if (jobDifficulty.size() < d) {
            return -1;
        }
        return dfs(jobDifficulty, 0, d);
    }
}
