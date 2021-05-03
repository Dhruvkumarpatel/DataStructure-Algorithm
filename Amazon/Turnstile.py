from typing import List
from collections import deque

def getTimes(numCustomers: int, arrTime: List[int], direction: List[int]) -> List[int]:
    enterQueue = deque()
    exitQueue = deque()
    time = -1
    lastDirection = 1 # exit
    
    # create the queues for enter and exit
    for i in range(numCustomers):
        if direction[i] == 1:
            # put in exit queue
            exitQueue.append((arrTime[i],i)) # (arrival time, id)
        else:
            enterQueue.append((arrTime[i],i))
    ans = [-1 for _ in range(numCustomers)]
    while enterQueue and exitQueue:
        if enterQueue[0][0] <= time and exitQueue[0][0] <=time:
            if time == -1 or lastDirection == 1:
                currQueue = exitQueue
            else:
                currQueue = enterQueue
        elif enterQueue[0][0] < exitQueue[0][0]:
            currQueue = enterQueue
            lastDirection = 0
        else:
            currQueue = exitQueue
            lastDirection = 1   
        arrivalTime, id = currQueue.popleft()
        time = max(time,arrivalTime)
        ans[id] = time
        time+=1
    remaining_queue = enterQueue if enterQueue else exitQueue
    while remaining_queue:
        arrivalTime,id = remaining_queue.popleft()
        time = max(time,arrivalTime)
        ans[id] = time
        time += 1

    return ans

res = getTimes(4,[0,0,1,5],[0,1,1,0])
print(res)