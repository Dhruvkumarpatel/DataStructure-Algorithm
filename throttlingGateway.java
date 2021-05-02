    private static int noOfRequestsDropped(int n, int requestArrivalTime[])
    {   
        int droppedRequest = 0;
        
        for (int i=1; i<requestArrivalTime.length; i++)
        {
            if (i > 2 && requestArrivalTime[i] == requestArrivalTime[i-3])
            {
                droppedRequest++;
            }
            else if (i > 19 && (requestArrivalTime[i] - requestArrivalTime[i-20]) <10)
            {
               droppedRequest++;
            }
            else if (i > 59 && (requestArrivalTime[i] - requestArrivalTime[i-60] < 60))
            {
                 droppedRequest++;
            }
        }
        
        return  droppedRequest;
    }