def number_of_swaps_to_sort(nums):
    counts = 0
    def merge_sort(nums):
        if len(nums) <= 1:
            return nums
        mid = len(nums) // 2
        left = merge_sort(nums[:mid])
        right = merge_sort(nums[mid:])
        return merge(left, right)
    def merge(left, right):
        nonlocal counts
        result = []
        l, r = 0, 0
        while l < len(left) or r < len(right):
            if r >= len(right) or (l < len(left) and left[l][1] <= right[r][1]):
                result.append(left[l])
                counts += r
                l += 1
            else:
                result.append(right[r])
                r += 1
        return result
    merge_sort(list(enumerate(nums)))
    return counts
