class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        
        int a[][] = new int[n][n];
        
         int i, k = 0, l = 0, m = n; 
        /*  k - starting row index 
        m - ending row index 
        l - starting column index 
        n - ending column index 
        i - iterator 
        */
        int element = 1;
  
        while (k < m && l < n) { 
            // Print the first row from the remaining rows 
            for (i = l; i < n; ++i) { 
                a[k][i] = element;
                element++;
            } 
            k++; 
  
            // Print the last column from the remaining columns 
            for (i = k; i < m; ++i) { 
                a[i][n - 1] = element;
                element++;
            } 
            n--; 
  
            // Print the last row from the remaining rows */ 
            if (k < m) { 
                for (i = n - 1; i >= l; --i) { 
                    a[m - 1][i] = element;
                    element++;
                } 
                m--; 
            } 
  
            // Print the first column from the remaining columns */ 
            if (l < n) { 
                for (i = m - 1; i >= k; --i) { 
                    a[i][l] = element;
                    element++;
                } 
                l++; 
            } 
    }
        
        return a;
    }
}