import re
from collections import Counter
def topWords(K,keywords,reviews):
  # This pattern will search for all the available keywords in the reviews
  pattern = re.compile(r'\b({})\b'.format('|'.join(keywords)),flags=re.IGNORECASE)
  counts = Counter()
  for review in reviews:
    matches = pattern.finditer(review)
    # To force the consideration of single instance
    wordSet = set()
    for m in matches:
      wordSet.add(m[0].lower())
    for word in wordSet:
      counts[word]+=1
      
  topKWords = list(sorted(counts.items(),key=lambda x:x[1],reverse=True))[:K]
  res = [] 
  for word,_ in topKWords:
    res.append(word)
  return res
#----------------- TEST CASE  
K = 2 
keywords = ["anacell", "cetracular", "betacellular"]
#print(r'\b({})\b'.format('|'.join(keywords)))

# reviews = [
#   "Anacell provides the best services in the city",
#   "betacellular has awesome services",
#   "Best services provided by anacell, everyone should use anacell",
# ]

reviews = [
  "I love anacell Best services; Best services provided by anacell",
  "betacellular has great services",
  "deltacellular provides much better services than betacellular",
  "cetracular is worse than anacell",
  "Betacellular is better than deltacellular.",
]
# output : ["anacell", "betacellular"]

res = topWords(K,keywords,reviews)
print(res)