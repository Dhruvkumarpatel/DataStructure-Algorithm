from functools import lru_cache
from typing import List
def number_of_options(a: List[int], b: List[int], c: List[int], d: List[int], limit: int) -> int:
    all_numbers = [a, b, c, d]
    n = len(all_numbers)
    for numbers in all_numbers:
        numbers.sort()
    # cost of (lowest, highest) combination
    ranges = [(0, 0)]
    # number of all combinations, ignoring limit
    combs = [1]
    for numbers in all_numbers:
        low, high = ranges[-1]
        ranges.append((numbers[0] + low, numbers[-1] + high))
        combs.append(len(numbers) * combs[-1])
    @lru_cache(None)
    def search(item: int, limit: int) -> int:
        # for persistent scan optimization
        num0 = all_numbers[0]
        # right boundary of `num0` with `<= left` num
        b0 = len(num0)
        numbers = all_numbers[item - 1]
        low, high = ranges[item - 1]
        ways = 0
        for number in numbers:
            left = limit - number
            # extreme case optimization
            if left < low:
                # not enough for cheapest combination, so 0 options;
                # same for higher `number`, so break
                break
            if left >= high:
                # enough for all combinations
                ways += combs[item - 1]
                continue
            # persistent scan optimization
            if item == 2:
                # will not go out of bounds because of `left < low` check
                while num0[b0 - 1] > left:
                    b0 -= 1
                # boundary is persisted between loops,
                # so faster than a linear scan every time
                ways += b0
                continue
            ways += search(item - 1, left)
        return ways
    return search(n, limit)