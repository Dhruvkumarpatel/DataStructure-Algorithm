import java.util.ArrayList;
import java.util.List;
public class NumOfSwaps {
    public static class Number {
        int index;
        int val;
        public Number(int i, int v) {
          index = i;
          val = v;
        }
      };
      private static int counts;
      private static List<Number> mergeSort(List<Number> nums) {
        if (nums.size() <= 1) {
          return nums;
        }
        int mid = nums.size() / 2;
        List<Number> left = mergeSort(nums.subList(0, mid));
        List<Number> right = mergeSort(nums.subList(mid, nums.size()));
        return merge(left, right);
      }
      private static List<Number> merge(List<Number> left, List<Number> right) {
        List<Number> result = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (l < left.size() || r < right.size()) {
          if (r >= right.size() || (l < left.size() && left.get(l).val <= right.get(r).val)) {
            result.add(left.get(l));
            counts += r;
            l++;
          } else {
            result.add(right.get(r));
            r++;
          }
        }
        return result;
      }
      public static int numberOfSwapsToSort(List<Integer> nums) {
          
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
          numbers.add(new Number(i, nums.get(i)));
        }
        mergeSort(numbers);
        return counts;
      }
  
    
}
