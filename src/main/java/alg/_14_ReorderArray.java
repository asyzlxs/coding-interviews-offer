package alg;

public class _14_ReorderArray {

    public static void reorderArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }

        int length = numbers.length;
        int begin = 0;
        int end = length - 1;
        while (begin < end) {
            while (begin < end && (numbers[begin] & 1) == 1) {
                ++begin;
            }
            while (begin < end && (numbers[end] & 1) == 0) {
                --end;
            }
            if (begin < end) {
                int tmp = numbers[begin];
                numbers[begin] = numbers[end];
                numbers[end] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 1, 2, 3, 1, 4, 123};
        reorderArray(numbers);
        for (int i : numbers) {
            System.out.print(i);
            System.out.print(' ');
        }
    }


}
