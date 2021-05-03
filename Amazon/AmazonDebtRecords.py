def debtRecords(records):
    legder = {}
    for record in records:
        if record[0] not in legder:
            legder[record[0]] = 0
        if record[1] not in legder:
            legder[record[1]] = 0
        legder[record[0]]-=int(record[2])
        legder[record[1]]+=int(record[2])
    res = []

    legder = dict(sorted(legder.items(), key=lambda item: item[1]))
    
    values = list(legder.items())
   
    if values[0][1] >= 0:
        return ["Nobody has a negative balance"]
    res.append(values[0][0])
    for i in range(1,len(values)):
        if values[i-1][1] == values[i][1]:
            res.append(values[i][0])
        else:
            break
    res = sorted(res)
    return res
"""
from typing import List
from collections import deque
def debtRecords(debts: List[List[str]]) -> List[str]:
    from typing import Counter
    bals: Counter[str] = Counter()
    for borrow, lend, amount in debts:
        amount = int(amount)
        bals[borrow] -= amount
        bals[lend] += amount
    neg = sorted((bal, name) for name, bal in bals.items() if bal < 0)
    if len(neg) == 0:
        return ['Nobody has a negative balance']
    return [name for bal, name in neg if bal == neg[0][0]]
"""
records = [['Alex','Blake' '2'],['Blake','Alex', '2'], ['Casey','Alex','5'], ['Blake','Casey','7'],['Alex','Blake','4'],['Alex','Casey','4']]
records = [['US', 'Japan','1'], ['US','China','20'], ['China','US','20'],['China','Japan','1'],['Japan','US','20'],['Japan','China','20']]
