from heapq import heapify, heappop
def optimizing_box_weights(arr: List[int]) -> List[int]:
    target = sum(arr) / 2
    for i in range(len(arr)):
        arr[i] = -arr[i]
    heapify(arr)
    cur_sum = 0
    res = []
    while cur_sum <= target:
        val = -heappop(arr)
        cur_sum += val
        res.append(val)
    res.reverse()
    return res
    return res