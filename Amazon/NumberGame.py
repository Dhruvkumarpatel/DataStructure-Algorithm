from functools import lru_cache
from math import gcd
def get_max_score(n: int, cards: List[int]) -> int:
    @lru_cache(None)
    def score(mask, level) -> int:
        if mask == 0:
            return 0
        return max(
            score(m, level - 1) + level * gcd(cards[i], cards[j])
            for i in range(len(cards))
            if mask & (1 << i)
            for j in range(i + 1, len(cards))
            if mask & (1 << j)
            for m in [mask & ~(1 << i) & ~(1 << j)]
        )
    return score((1 << len(cards)) - 1, n)
