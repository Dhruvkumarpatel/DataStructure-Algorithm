"""
An Amazon Warehouse manager needs to create a shipment to fill a truck. 
All of the products in the warehouse are in boxes of the same size. 
Each product is packed in some number of units per box.

Given the number of boxes the truck can hold, write an algorithm to determine 
the maximum number of units of any mix of products that can be shipped.

Input

The input to the function method consists of five arguments:

num, an integer representing number of products;
boxes, a list of integers representing the number of available boxes for products;
unitSize, an integer representing size of unitsPerBox;
unitsPerBox, a list of integers representing the number of units packed in each box;
truckSize, an integer representing the number of boxes the truck can carry.

Output

Return an integer representing the maximum units that can be carried by the truck.

Constraints
1 <= |boxes| <= 10^5
|boxes| == |unitsPerBox|
1 <= boxes[i] <= 10^7
1 <= i <= |boxes|
1 <= unitsParBox[i] <= 10^5
1 <= j <= |unitsPerBox|
1 <= truckSize <= 10 ^ 8

Note

[list name] denotes length of the list.

Example

Input:
num=3
boxes=[1,2,3]
unitSize=3
unitsPerBox= [3,2,1]
truckSize = 3

Output
7

Explanation:
Product 0: because boxes[0] = 1, we know there is 1 box in product 0. And because unitsPerBox[0] = 3, we know there is 1 box with 3 units in product 0.
Product 1: 2 boxes with 2 units each
Product 2: 3 boxes with 1 unit each
Finall we have the packed products like a list : [3, 2, 2, 1, 1, 1]
The truckSize is 3, so we pick the top 3 from the above list, which is [3, 2, 2], and return the sum 7.
The maximum number of units that can be shipped = 3 + 2 + 2 = 7 units
"""

def GetMaxUnits(boxes,unitsPerBox,size):
    
    combined = [[boxes[i],unitsPerBox[i]] for i in range(len(boxes))]
    combined = sorted(combined, key = lambda tuple : tuple[1],reverse = True)
    units = 0
    for i in range(len(boxes)):
        if size <= 0:
            break
        units += (combined[i][1]*min(combined[i][0],size))
        size -= min(combined[i][0],size)
        
    return units
# boxes = [1,2,3]
# unitsPerBox = [3,2,1]
# size = 3
from typing import List

def fillTheTruck(num: int, boxes: List[int], unitSize: int, unitsPerBox: List[int], truckSize: int) -> int:
    ans = 0
    boxes_left = truckSize
    for unit, i in sorted([(unit, i) for i, unit in enumerate(unitsPerBox)], reverse=True):
        if boxes_left <= boxes[i]:
            ans += boxes_left * unit
            break
        else:
            ans += boxes[i] * unit
            boxes_left -= boxes[i]
    return ans
print(GetMaxUnits([2,1,3],[2,3,1],3))