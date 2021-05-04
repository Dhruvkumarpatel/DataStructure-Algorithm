public static int cutOffRank(int cutOffRank, int num, int[] scores) {
    
    TreeMap<Integer,Integer> ts = new TreeMap<>(Collections.reverseOrder());
    
    for(int x: scores){
        ts.put(x,ts.getOrDefault(x,0)+1);
    }
    
    int res = 0;
    
    for(Map.Entry<Integer,Integer> e : ts.entrySet()){
        
        if(cutOffRank>0 && e.getKey()>0){
            res+= e.getValue();
        }
        cutOffRank-=e.getValue() ;
        
    }
    
    
    return res;
}

public static void main (String[] args) throws java.lang.Exception
{
    int arr[] = {2,2,3,4,5};
	// your code goes here
	System.out.println(cutOffRank(4,5,arr));
}