    public static int finalSignOfArrayProduct(int input[])
    {
        int countNegative = 0;
        int countZeros = 0;
        
        for (int i : input)
        {
            if (i == 0)
            {
                countZeros += 1;
            }
            else if (i < 0)
            {
                countNegative += 1;
            }
        }
        
        if (countZeros > 0)
        {
            return 0;
        }
        
        if (countNegative % 2 != 0)
        {
            return -1;
        }
        
        return 1;
    }