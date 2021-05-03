import java.util.*;
import java.io.*;

public class DebuggingOA{
    /*
    The following function returns a positive integer 
    representing the sum of numbers in the inputString.
    The following code compiles successfully but fails 
    to return the desired result. Your task is to fix 
    the code so that it passes all test cases.
     */
    public static int calculateSumOfNumbersInString(String inputString) {
        String temp = "";
        int sum = 0;
        for(int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if(Character.isDigit(ch))
                temp += ch;
            else
            { // Make change here 
                sum += Integer.parseInt(temp);
                temp = "0";
            }
                
        }
        return sum + Integer.parseInt(temp);
    }

    /*
    The following function returns a boolean value representing
    if there is a pair with given sum exists in the array.
    The following code compiles successfully but fails to return
    the desired result. Your task is to fix the code so that it passes all test cases.
     */
    public static boolean checkPairSumExists(int rows, int cols, int[][] arr, int sum) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(set.contains(sum - arr[i][j])) {
                    return true;
                } else {

                    set.add(arr[i][j]); // make change here
                }
            }
        }
        return false;
    }

    static boolean is_vowel(char ch) {
        return (ch == 'a') || (ch == 'e') ||
                (ch == 'i') || (ch == 'o') ||
                (ch == 'u');
    }
    /*
    The following function returns a string value representing
    the string left after removing consecutive vowels from the string.
    The following code compiles successfully but fails to return the desired result.
    Your task is to fix the code so that it passes all test cases.
    */
    public static String removeConsecutiveVowels(String str) {
        String str1 = "";
        str1 = str1+str.charAt(0);
        for(int i = 1; i < str.length(); i++)
        {
            if((is_vowel(str.charAt(i - 1))) &&
                    (is_vowel(str.charAt(i)))) {
                continue;       
            }
            char ch = str.charAt(i);
            str1 = str1 + ch;
            
        }
        return str1;
    }

    /*
    The following function returns a string representing the reversed string 
    in such a way that the position fo the special chars are not affected.
    The following code compiles successfully but fails to return the desired result.
    Your task is to fix the code so that it passes all test cases.
    */
    public static String reverseAlphabetCharsOnly(String inputString) {
        char[] inputChar = inputString.toCharArray();
        int right = inputString.length() - 1;
        int left = 0;
        while(left < right) {
            if(!Character.isAlphabetic(inputChar[left]))
                left++;
            else if(!Character.isAlphabetic(inputChar[right]))
                right--;
            else
            {
                char temp = inputChar[left];
                inputChar[left] = inputChar[right];
                inputChar[right] = temp;
                left++; // Add these inside else
                right--;  // add inside else  
            }
            
        }
        return new String(inputChar);
    }


    /*
    The following function returns a Boolean value "true" if 
    the product of digits at the even and odd places of a number are equal.
    The following code compiles successfully but fails to return the desired result.
    Your task is to fix the code so that it passes all test cases.
     */
    public static boolean compareProduct(int num) {
        if (num < 10)
            return false;
        int oddProdValue = 1, evenProdValue = 1;

        while(num > 0) {
            int digit = num % 10;
            oddProdValue *= digit;
            num = num / 10;
            if(num == 0)
                break;
            digit = num % 10;
            evenProdValue *= digit;
            num = num / 10;
        }
        if(evenProdValue == oddProdValue)
            return true;
        return false;
    }

    /*
    Count the triplets 
     */
    public int countTripletSumPermutations(int size, int[] arr, int tripletSum)
    {
        int count = 0;
        for(int i = 0; i < size - 2; i++)
        {
            if(tripletSum % arr[i] == 0)
            {
                // Change 0 to i+1
                for(int j = i+1; j < size - 1; j++)
                {
                    if(tripletSum % (arr[i] * arr[j]) == 0)
                    {
                        int value = tripletSum / (arr[i] * arr[j]);
                        for(int k = j + 1; k < size; k++)
                            if(arr[k] == value)
                                count++;
                    }
                }
            }

        }
        return count;
    }
    public static void main(String []args)
    {
        System.out.println(calculateSumOfNumbersInString("1a2a3"));
        
    }
    
}