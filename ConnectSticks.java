import java.util.*;
import java.util.stream.Collectors;

class ConnectSticks {
    public static void main(String args[]){

        int sticks[] = new int[]{2,4,3};

        int result = Integer.MAX_VALUE;

    List<Integer> sortedSticks = Arrays.stream(sticks).boxed().collect(Collectors.toList());    
        
    while (sortedSticks.size() > 1)
    { 
        int array[] = sortedSticks.stream().mapToInt(i->i).toArray();
        sortArrayByHeapSort(array);
        
        sortedSticks = Arrays.stream(array).boxed().collect(Collectors.toList());
        
        int sum = sortedSticks.get(0) + sortedSticks.get(1);
        result += sum;
        sortedSticks.remove(0);
        sortedSticks.remove(1);
        sortedSticks.add(sum);

    }

    System.out.println(result);
    }
    
    private static void sortArrayByHeapSort(int[] sticks)
    {
        int n = sticks.length;
        
    for (int i=n/2-1; i>=0; i++)
    {
        generateMinHeap(sticks, i, sticks.length);
    }
        
    for (int j=0; j<n; j++)
    {
        int minimum = sticks[j];
        
        int temp = sticks[j];
        sticks[j] = sticks[sticks.length - 1];
        sticks[sticks.length - 1] = temp;
        
        n = n - 1;
        
        generateMinHeap(sticks,0, n);
    }
    }
    
    private static void generateMinHeap(int[] sticks, int i, int n)
    {
        int root = i;
        int left = (2*i) + 1;
        int right = (2*i) + 2;
        
        int min = root;
        
        if (left < n && sticks[left] < sticks[min])
        {
            min = left;
        }
        if (right < n && sticks[right] < sticks[min])
        {
            min = right;
        }
        
        if (min != root)
        {
            int temp = sticks[root];
            sticks[root] = sticks[min];
            sticks[min] = temp;
            
            generateMinHeap(sticks, min, n);
        }
    }
    
}