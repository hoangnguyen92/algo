package problemsolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickSort {
    int totalComparison = 0;

    public int[] solve(int[] arr) {
        int[] numbers = new int[10000];
        int index = 0;
        try {
            File myObj = new File("/Users/hoangnguyen/dev/projects/Practice/JavaPractice/src/problemsolver/quickSort.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                numbers[index] = Integer.parseInt(data);
                index++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (arr == null) {
            return null;
        }
        int[] sort = sort(numbers, 0, numbers.length);
        System.out.println(totalComparison);
        return sort;
    }

    private int[] sort(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }

        int pivot = arr[left];
        int i = left + 1;
        totalComparison += right - left - 1;
        for (int j = left + 1; j < right; j++) {
            if (arr[j] < pivot) {
                swapElementInArray(arr, i, j);
                i++;
            }
        }
        swapElementInArray(arr, left, i - 1);
        sort(arr, left, i - 1);
        sort(arr, i, right);
        return arr;
    }

    private void swapElementInArray(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
