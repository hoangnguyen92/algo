package problemsolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergeSort {

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

//        sort(numbers, 0, numbers.length - 1);


        return sort(numbers);
    }

    private int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        System.arraycopy(arr, 0, leftArr, 0, mid);

        int[] rightArr = new int[arr.length - mid];
        System.arraycopy(arr, mid, rightArr, 0, arr.length - mid);

        leftArr = sort(leftArr);
        rightArr = sort(rightArr);

        return merge(leftArr, rightArr);
    }

    private int[] merge(int[] leftArr, int[] rightArr) {
        int[] result = new int[leftArr.length + rightArr.length];
        int leftPointer = 0, rightPointer = 0;
        for (int i = 0; i < result.length; i++) {
            if (leftPointer >= leftArr.length) {
                result[i] = rightArr[rightPointer];
                rightPointer++;
                continue;
            }
            if (rightPointer >= rightArr.length) {
                result[i] = leftArr[leftPointer];
                leftPointer++;
                continue;
            }

            if (leftArr[leftPointer] < rightArr[rightPointer]) {
                result[i] = leftArr[leftPointer];
                leftPointer++;
            } else {
                result[i] = rightArr[rightPointer];
                rightPointer++;
            }
        }
        return result;
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
