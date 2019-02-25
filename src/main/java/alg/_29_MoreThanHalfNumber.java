package alg;

import java.util.HashMap;

public class _29_MoreThanHalfNumber {

    /**
     * 时间复杂度O(n),空间复杂度数O(n)
     */
    public static int moreThanHalfNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return -1;
        int middle = numbers.length / 2;
        HashMap<Integer, Integer> nums = new HashMap<>();
        for (int i : numbers) {
            if (nums.containsKey(i)) {
                nums.put(i, nums.get(i) + 1);
                if (nums.get(i) > middle)
                    return i;
            } else {
                nums.put(i, 1);
            }
        }
        return -1;
    }

    public static int moreThanHalfNumber_1(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;
        int p = partition(numbers, 0, numbers.length - 1);
        int middle = numbers.length / 2;
        int low = 0;
        int high = numbers.length - 1;
        while (p != middle) {
            if (p > middle) {
                high = p - 1;
                p = partition(numbers, low, high);
            } else {
                low = p + 1;
                p = partition(numbers, low, high);
            }
        }
        return numbers[p];

    }

    public static void quickSort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    public static void quickSort(int[] numbers, int start, int end) {
        if (numbers.length == 0)
            return;
        int p = partition(numbers, start, end);
        quickSort(numbers, start, p);
        quickSort(numbers, p, end);
    }

    public static int partition(int[] numbers, int start, int end) {
        int val = numbers[start];
        int low = start + 1;
        int high = end;
        while (true) {
            while (low <= end && numbers[low] < val)
                ++low;
            while (high >= low && numbers[high] > val)
                --high;
            if (low > high)
                break;
            swap(numbers, low++, high--);
        }
        swap(numbers, start, high);
        return high;

    }


    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


    public static void main(String[] args) {
        int[] test = {1, 3, 7, 5, 9};
        int[] half = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNumber(half));
        System.out.println(moreThanHalfNumber_1(half));
    }

}
