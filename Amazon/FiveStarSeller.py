from heapq import heapify, heappop, heappush
class Rating:
    def __init__(self, num, den):
        self.num = num
        self.den = den
    def __float__(self):
        return self.num / self.den
    def __lt__(self, other):
        return self.gain > other.gain
    @property
    def succ(self):
        return Rating(self.num + 1, self.den + 1)
    @property
    def gain(self):
        return float(self.succ) - float(self)
def five_star_reviews(ratings: List[List[int]], threshold: int) -> int:
    num_rats = len(ratings)
    # priority queue ordered by gain descending
    rats = [Rating(n, d) for n, d in ratings]
    heapify(rats)
    # how much more do we need to reach threshold
    diff = threshold / 100 - sum(float(r) for r in rats) / num_rats
    # count of five star reviews added
    count = 0
    while diff > 0:
        s = heappop(rats)
        heappush(rats, s.succ)
        diff -= s.gain / num_rats
        count += 1
    return count