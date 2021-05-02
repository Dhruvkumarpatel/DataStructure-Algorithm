class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        
        int longestDuration = releaseTimes[0];
        char charWithLongDur = keysPressed.charAt(0);
        
        for (int i=1; i<keysPressed.length(); i++)
        {
            int innerDuration = releaseTimes[i] - releaseTimes[i-1];
            char newChar = keysPressed.charAt(i) ;
            
            if (innerDuration == longestDuration)
            {
                charWithLongDur = charWithLongDur - newChar < 0 ?  newChar : charWithLongDur;
                continue;
            }    
            
            if (innerDuration > longestDuration)
            {
                charWithLongDur = newChar;
                longestDuration = innerDuration;
            }
        }
        
        
        return charWithLongDur;
    }
}