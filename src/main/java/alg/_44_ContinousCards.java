package alg;

import java.util.Arrays;

public class _44_ContinousCards {


    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 2)
            return false;

        quickSort(numbers, 0, numbers.length - 1);


        int length = numbers.length;
        int zeroNumbers = 0;
        int diff = 0;
        for (int i = 0; i < length; ++i) {
            if (numbers[i] == 0)
                ++zeroNumbers;
            else if (i != 0 && numbers[i - 1] != 0 && numbers[i] - numbers[i - 1] > 1)
                diff += (numbers[i] - numbers[i - 1] - 1);
        }
        System.out.println("zeroNumbers:" + zeroNumbers);
        System.out.println("diff:" + diff);


        return (diff == 0 || diff <= zeroNumbers);

    }


    public static void quickSort(int[] data, int begin, int end) {
        if (data.length == 0)
            return;
        if (begin >= end)
            return;
        int p = partition(data, begin, end);
        quickSort(data, begin, p - 1);
        quickSort(data, p + 1, end);

    }


    public static int partition(int[] data, int begin, int end) {
        int left = begin + 1;
        int right = end;
        while (true) {
            while (left <= end && data[left] < data[begin])
                ++left;
            while (right >= left && data[right] > data[begin])
                --right;
            if (left > right)
                break;
            swap(data, left++, right--);
        }
        swap(data, begin, right);
        return right;
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    public static void main(String[] args) {
        int[] numbers = {0, 0, 2, 8, 4};
        int[] numbers1 = {0, 1, 2, 3, 4};
        quickSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
        System.out.println(isContinuous(numbers));
        System.out.println(isContinuous(numbers1));
    }
}
