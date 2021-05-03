from collections import defaultdict
# def findNearestCities(numOfCities,cities,xCoordinates,yCoordinates,numOfQueries,queries):
#     """ 
#     A lot of information is given in array format can be combined in form of 
#     class object so that we can access it quickly
#     """
#     class City:
#         def __init__(self,name,x,y):
#             self.name = name
#             self.x = x
#             self.y = y
#         def dist(self,otherCity):
#             return (self.x-otherCity.x)**2 + (self.y-otherCity.y)**2
#     xs = defaultdict(list)
#     ys = defaultdict(list)
#     cityNameMap = {}
#     # Prepare the maps for city with same x coordinates and y coorddinates
#     for i in range(numOfCities):
#         name = cities[i]
#         city = City(name,xCoordinates[i],yCoordinates[i])
#         xs[city.x].append(city)
#         ys[city.y].append(city)
#         cityNameMap[name] = city
#     ans = []
#     cache = {}
#     for name in queries:
#         if name in cache:
#             ans.append(cache[name])
#             continue
#         city = cityNameMap[name]
#         # all the possible options to find nearest city
#         # here were are combining cities with both x and y same coordinate
#         search_cities = xs[city.x] + ys[city.y]
#         if len(search_cities) == 2:
#             ans.append("None")
#             continue
#         search_cities.sort(key=lambda x:x.dist(city))
#         closest=search_cities[2].name
#         ans.append(closest)
#         cache[city.name] = closest
#         cache[closest] = city.name
#     return ans
def findNearestCities(pins, x_coordinates, y_coordinates,target_pins):
    pinData = []
    
    def dist(x1,y1,x2,y2):
        return (x1-x2)**2 + (y1-y2)**2

    
    for i in range(len(pins)):
        pinData.append([pins[i],x_coordinates[i],y_coordinates[i]])

    


cities = ["c1", "c2","c3"]
xCoordinates = [3, 2, 1]
yCoordinates = [3, 2, 3]
queries = ["c1", "c2", "c3"]
#print(findNearestCities(3,cities,xCoordinates,yCoordinates,3,queries))

