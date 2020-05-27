package problemsolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Java program to print all permutations of a
// given string.
public class Permutation
{
    public static void main(String[] args)
    {
//        String str = "abc";
//        int n = str.length();
//        Permutation permutation = new Permutation();
//        permutation.permute(str, 0, n-1);
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        Permutation permutation = new Permutation();
        permutation.permuteInteger(arr,result, 0, arr.length);

        System.out.println(result);
    }

    private void permuteInteger(int[] arr, List<List<Integer>> result, int left, int right) {
        if(left == right){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            result.add(list);
            return;
        }

        for (int i = left; i < right; i++) {
            swapArray(arr, i , left);
            permuteInteger(arr, result, left + 1, right);
            swapArray(arr, i , left);
        }

    }

    private void swapArray(int[] arr, int i, int left) {
        int temp = arr[i];
        arr[i] = arr[left];
        arr[left] = temp;
    }

    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
