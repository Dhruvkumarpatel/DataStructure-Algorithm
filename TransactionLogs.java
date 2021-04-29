  /**
    
    logs:

345366 899212 45
029323 382391 23
382391 345366 15
029323 382391 77
345366 382391 23
029323 345366 13
382391 382391 23
...
threshold: 3

Output: [029323, 345366, 382391]

Given a threshold number, find the number of users that appear at least as many times as this threshold.

Return a list of sorted user IDs. If the same user appears in the same line, only count them once.
     [029323, 345366, 382391]
    
    
    **/
    
    private static List<String> sortedUserIdsThatAppearedAsThresoldTimes(List<String> logs, int thresold)
    {
        
        final Map<String, Integer> userIdToCount = new TreeMap<>();
        
        for (String log : logs)
        {
            final String split[] = log.split(" ");
            
            String user1 = split[0];
            String user2 = split[1];
            
            if (userIdToCount.containsKey(user1))
            {
                userIdToCount.put(user1, userIdToCount.getOrDefault(user1, 0) + 1);
            }
            else
            {
                userIdToCount.put(user1, 1);
            }
            
            if (userIdToCount.containsKey(user2))
            {
                userIdToCount.put(user2, userIdToCount.getOrDefault(user2, 0) + 1);
            }
            else
            {
                userIdToCount.put(user2, 1);
            }
            
            if (user1.equals(user2))
            {
                userIdToCount.put(user1, userIdToCount.getOrDefault(user1, 0) - 1);
            }
        }
        
        
        Iterator<Map.Entry<String, Integer>> iterator = userIdToCount.entrySet().iterator();
        final List<String> result = new ArrayList<>();
  
        while (iterator.hasNext()) {
  
            // Get the entry at this iteration
            Map.Entry<String, Integer> entry= iterator.next();
            
            if (entry.getValue() < thresold)
            {
                iterator.remove();
            }
            else
            {
                result.add(entry.getKey());
            }
        }
        
        return result;
    }