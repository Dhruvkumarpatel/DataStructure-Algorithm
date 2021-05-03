def groups(M):
    
    def dfs(i,j,M):
        if 0 <= i <len(M) and 0 <= j <len(M[0]) and M[i][j]==1:
            dx = [-1,1,0,0]
            dy = [0,0,-1,1]
            


    cnt = 0 
    for i in range(len(M)):
        for j in range(len(M[0])):
            if M[i][j]==1:
                dfs(i,j,M)


print(groups([[1,1,0],
              [0,1,0],
              [0,0,1]])) # 2 
print(groups([[1,1,0],
              [1,1,0],
              [0,0,1]])) # 2 

print(groups([[1,1,0,0],
              [1,1,1,0],
              [0,1,1,0],
              [0,0,0,1]])) # 2
print(groups([[1,0,0,0,0],
              [0,1,0,0,0],
              [0,0,1,0,0],
              [0,0,0,1,0],
              [0,0,0,0,1]])) # 5
