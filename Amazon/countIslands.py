"""
Using Iterative BFS Solution
"""
def count_number_of_islands(grid: List[List[int]]) -> int:
    num_rows = len(grid)
    num_cols = len(grid[0])
    def get_neighbors(coord):
        res = []
        row, col = coord
        delta_row = [-1, 0, 1, 0]
        delta_col = [0, 1, 0, -1]
        for i in range(len(delta_row)):
            r = row + delta_row[i]
            c = col + delta_col[i]
            if 0 <= r < num_rows and 0 <= c < num_cols:
                res.append((r, c))
        return res
      
    def bfs(start, visited):
        queue = deque([start])
        r, c = start
        visited[r][c] = True
        while len(queue) > 0:
            node = queue.popleft()
            for neighbor in get_neighbors(node):
                r, c = neighbor
                if grid[r][c] == 0 or visited[r][c]:
                    continue
                queue.append(neighbor)
                visited[r][c] = True
    
    count = 0
    # note that all bfs share the same visited set
    visited = [[False for c in range(num_cols)] for r in range(num_rows)]
    # bfs starting from each unvisited land cell
    for r in range(num_rows):
        for c in range(num_cols):
            if grid[r][c] == 0 or visited[r][c]:
                continue
            bfs((r, c), visited) 
            count += 1 # bfs would find 1 connected island, increment count
    return count