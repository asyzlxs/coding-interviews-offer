package alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class _30_KLeastNumbers {

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * 数组顺序改变
     * @param numbers
     * @param k
     * @return
     */

    public static int[] getLeastNumbers(int[] numbers, int k) {
        int[] result = new int[k];
        int start = 0;
        int end = numbers.length - 1;
        int p = partition(numbers, start, end);
        while (p != k - 1) {
            if (p > k - 1)
                end = p - 1;
            else
                start = p + 1;
            p = partition(numbers, start, end);
        }

        for (int i = 0; i < k; ++i) {
            result[i] = numbers[i];
        }
        return result;
    }

    /**
     * 时间复杂度O(nlogk)
     * 空间复杂度O(k)
     * 数组顺序没变
     * TreeSet 红黑树
     * @param numbers
     * @param k
     * @return
     */

    public static ArrayList<Integer> getLeastNumbers_1(int[] numbers, int k){
        TreeSet<Integer> set = new TreeSet<>();
        for(int i:numbers){
            if(set.size()<k)
                set.add(i);
            else {
                if(set.last()>i){
                    set.pollLast();
                    set.add(i);
                }
            }
        }
        return new ArrayList<>(set);
    }


    public static int partition(int[] numbers, int start, int end) {
        if (numbers == null || numbers.length == 0) return 0;
        int val = numbers[start];
        int low = start + 1;
        int high = end;
        while (true) {
            while (low <= end && numbers[low] < val)
                ++low;
            while (high >= low && numbers[high] > low)
                --high;
            if (low > high)
                break;
            swap(numbers, low++, high--);
        }
        swap(numbers, start, high);
        return high;
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] numbers = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(getLeastNumbers(numbers, 4)));
        System.out.println(getLeastNumbers_1(numbers, 4).toString());

    }
}
