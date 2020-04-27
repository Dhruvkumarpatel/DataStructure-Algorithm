class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0)
        {
            return false;
        }
        
        int rowsOrCols = Math.min(matrix.length, matrix[0].length);
        
        for (int i=0; i<rowsOrCols; i++)
        {
            boolean vertically = isPresent(target, matrix, i, true);
            boolean horizontally = isPresent(target, matrix, i, false);
            
            if (horizontally || vertically)
            {
                return true;
            }
        }
        
        return false;
        
    }
    
    
    private static boolean isPresent(int target, int matrix[][], int start, boolean vertical)
    {
        int low = start;
        int high = vertical ? matrix[0].length - 1 : matrix.length - 1;
        
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            
            if (vertical)
            {
                if (matrix[start][mid] == target)
                {
                    return true;
                }
                else if (target > matrix[start][mid])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
            else
            {
                if (matrix[mid][start] == target)
                {
                    return true;
                }
                else if (target > matrix[mid][start])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
        
        return false;
    }
}