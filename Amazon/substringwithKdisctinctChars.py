"""
Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.
input: s = awaglknagawunagwkwagl,k = 4
Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
"""
from collections import deque
def subString(s,k):
    res = []
    temp = ""
    for i in range(len(s)):
        if s[i] not in temp and len(temp)<k:
            temp+=s[i]
        else:
            if len(temp) == k:
                if temp not in res:
                    res.append(temp)
                temp = temp[1:]
            if s[i] in temp:
                temp = temp.split(s[i])[-1]+s[i]
            else:
                temp += s[i]
    if temp not in res and len(temp) == k:
        res.append(temp)
    return res

s = "awaglknagawunagwkwagl"
k = 4
s = "abacab"
k = 3
print(subString(s,k))