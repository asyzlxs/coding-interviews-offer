package alg;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }

        mergeSort(numbers, 0, numbers.length - 1);
    }

    public static void mergeSort(int[] numbers, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(numbers, left, mid);
        mergeSort(numbers, mid + 1, right);
        merge(numbers, left, mid, right);
    }

    public static void merge(int[] numbers, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        int[] temp = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (numbers[i] <= numbers[j])
                temp[index++] = numbers[i++];
            else
                temp[index++] = numbers[j++];
        }

        while (i <= mid) {
            temp[index++] = numbers[i++];
        }

        while (j <= right) {
            temp[index++] = numbers[j++];
        }

        for (int k = 0; k < right - left + 1; ++k) {
            numbers[left + k] = temp[k];
        }

    }

    public static void main(String[] args) {
        int[] numbers = {5,9,7,1,3};
        System.out.println(Arrays.toString(numbers));
        mergeSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}
