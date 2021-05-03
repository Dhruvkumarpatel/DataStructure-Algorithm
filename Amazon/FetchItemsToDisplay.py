from typing import List
def fetchItemsToDisplay(sortParameter:int, sortOrder:int,  itemsPerPage:int, pageNumber:int, numOfItems:int, items: List[List[str]]) -> List[str]:
    # WRITE YOUR BRILLIANT CODE HERE
    items = [[x[0], int(x[1]), int(x[2])] for x in items] # convert string to int
    items.sort(key=lambda x: x[sortParameter], reverse=sortOrder==1) # sort by sortParameter and reverse order if needed
    n = len(items)
    start_index = itemsPerPage * pageNumber # find the start index of the first item on the target page
    return [name for name, _, _ in items[start_index: start_index + itemsPerPage]] # return only the name of each item on the page
