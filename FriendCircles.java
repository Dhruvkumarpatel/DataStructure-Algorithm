 
    private static int numberOfFriendsCircle(int input[][])
    {
        final Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[input.length];
        // 0-> 1 -> 2
        
        int count = 0;
        
        for (int i=0; i<input.length; i++)
        {
            if (!visited[i])
            {
                queue.add(i);
                
                while (!queue.isEmpty())
                {
                    int remove = queue.remove();
                    visited[remove] = true;
                    
                    for (int j=0; j<input[i].length; j++)
                    {
                        if (input[remove][j] == 1 && !visited[j])
                        {
                            queue.add(j);
                        }
                    }
                }
                
                count++;
            }
        }
        
        return count;
           
    }