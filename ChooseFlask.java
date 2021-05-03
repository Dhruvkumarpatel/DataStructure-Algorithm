import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ChooseFlask {
  public int chooseAFlask(List<Integer> requirements, List<List<Integer>> markings) {
    requirements.sort(Comparator.comparingInt(a -> a));

    Map<Integer, Set<Integer>> flaskSize = new HashMap<>();

    for (List<Integer> marking : markings) {
      if (marking.get(1) <= requirements.get(0)) {
        continue;
      }

      flaskSize.compute(marking.get(0), (k, v) -> {
        if (v == null) {
          v = new TreeSet<>();
        }

        v.add(marking.get(1));
        return v;
      });
    }

    int maxLoss = Integer.MAX_VALUE;
    int flask = 0;
    int loss;
    for (Integer key : flaskSize.keySet()) {
      TreeSet<Integer> vals = (TreeSet<Integer>) flaskSize.get(key);
      if (vals.headSet(requirements.get(requirements.size() - 1), true).isEmpty()) {
        continue;
      }

      loss = 0;

      for (Integer req : requirements) {
        Integer opt = vals.headSet(req, true).pollFirst();

        if (opt == null) {
          loss = maxLoss;
          break;
        }

        loss += opt - req;
      }

      if (loss < maxLoss) {
        maxLoss = loss;
        flask = key;
      }
    }

    return flask;
  }

  private static void test(List<Integer> requirements, int markingArrays[][]) {
    List<List<Integer>> markings = new ArrayList<>();

    for (int markingArray[]: markingArrays) {
      markings.add(Arrays.asList(markingArray[0], markingArray[1]));
    }

    ChooseFlask chooseFlask = new ChooseFlask();
    System.out.println(chooseFlask.chooseAFlask(requirements, markings));
  }

  public static void main(String[] args) {
    test(Arrays.asList(4,6,6,7), new int[][]{{0, 3},{0,5},{0,7},{1,6},{1,8},{1,9},{2,3},{2,5},{2,6}});
  }
}