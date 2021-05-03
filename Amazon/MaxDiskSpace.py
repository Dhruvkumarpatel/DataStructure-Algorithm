from collections import deque
def availableDiskSpace(numComputer, hardDiskSpace, seg_len):
    if numComputer == 0:
        return 0
    if seg_len == 1:
        return max(hardDiskSpace)
    q = deque()
    def clearQueue(i):
        if q and q[0] == i-seg_len:
            q.popleft()
        while q and hardDiskSpace[i] < hardDiskSpace[q[-1]]:
            q.pop()
    minIdx = 0
    for i in range(seg_len):
        clearQueue(i)
        q.append(i)
        if hardDiskSpace[i] < hardDiskSpace[minIdx]:
            minIdx = i
    res = [hardDiskSpace[minIdx]]
    
    n = len(hardDiskSpace)
    for i in range(seg_len,n):
        clearQueue(i)
        q.append(i)
        res.append(hardDiskSpace[q[0]])
        
    return max(res)

# Solution 2
def availableDiskSpace2(numComputer, hardDiskSpace, seg_len):
    res = float('-inf')
    q = deque()
    for i, space in enumerate(hardDiskSpace):
        if len(q) > 0 and q[0][0] <= i - seg_len:
            q.popleft()
        while len(q) > 0 and q[-1][1] >= space:
            q.pop()
        q.append((i, space))
        if i >= seg_len:
            res = max(res, q[0][1])
    return res
hardDiskSpace = [8,2,4]
segmentSize = 2
print(availableDiskSpace(3,hardDiskSpace,segmentSize))