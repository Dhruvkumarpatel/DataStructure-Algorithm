import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
public class Turnstile {
    public static List<Integer> getTimes(int numworker, List<Integer> arrTime, List<Integer> direction) {
        // WRITE YOUR BRILLIANT CODE HERE
        ArrayDeque<Map.Entry<Integer, Integer>> enterQueue = new ArrayDeque<>();
        ArrayDeque<Map.Entry<Integer, Integer>> exitQueue = new ArrayDeque<>();
        int curTime = -1;
        String lastUsedType = "exit";
        for (int i = 0; i < numworker; i++) {
            if (direction.get(i) == 0)
                enterQueue.offer(Map.entry(arrTime.get(i), i));
            else
                exitQueue.offer(Map.entry(arrTime.get(i), i));
        }
        List<Integer> ans = Arrays.asList(new Integer[numworker]);
        while (!enterQueue.isEmpty() && !exitQueue.isEmpty()) {
            ArrayDeque<Map.Entry<Integer, Integer>> curQueue;
            if (enterQueue.peek().getKey() <= curTime && exitQueue.peek().getKey() <= curTime) {
                if (curTime == -1 || lastUsedType == "exit")
                    curQueue = exitQueue;
                else
                    curQueue = enterQueue;
            } else if (enterQueue.peek().getKey() < exitQueue.peek().getKey()) {
                curQueue = enterQueue;
            } else {
                curQueue = exitQueue;
            }
            Map.Entry<Integer, Integer> worker = curQueue.poll();
            int time = worker.getKey();
            int i = worker.getValue();
            lastUsedType = curQueue == enterQueue ? "enter" : "exit";
            curTime = Math.max(time, curTime);
            ans.set(i, curTime);
            curTime++;
        }
        ArrayDeque<Map.Entry<Integer, Integer>> remainingQueue = !enterQueue.isEmpty() ? enterQueue : exitQueue;
        while (!remainingQueue.isEmpty()) {
            Map.Entry<Integer, Integer> worker = remainingQueue.poll();
            int time = worker.getKey();
            int i = worker.getValue();
            curTime = Math.max(time, curTime);
            ans.set(i, curTime);
            curTime++;
        }
        return ans;
    }
}

public int solution(int A, int B) {
    int start = (int) Math.sqrt(A);
    int end = (int) Math.sqrt(B);
    int firstM = start * (start + 1);
    int endM = end * (end + 1);
    int includeFirst = firstM >= A && firstM <= B ? 1 : 0;
    int includeEnd = endM >= A && endM <= B ? 1 : 0;
    int result = end - start - 1 + includeFirst + includeEnd;
    return result >= 0 ? result : 0; //We need to do this as A can be equal to B
    }