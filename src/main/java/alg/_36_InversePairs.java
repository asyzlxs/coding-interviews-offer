package alg;

public class _36_InversePairs {

    public static int inversePairs(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return 0;
//        int[] copy = new int[numbers.length];
//        for (int i = 0; i < numbers.length; ++i) {
//            copy[i] = numbers[i];
//        }

        int inversePairs = inversePairsCore(numbers, 0, numbers.length - 1);

        return inversePairs;

    }


    public static int inversePairsCore(int[] numbers, int start, int end) {
        if (start == end)
            return 0;

        int length = (end - start) / 2;
        int left = inversePairsCore(numbers, start, start + length);
        int right = inversePairsCore(numbers, start + length + 1, end);
        int[] copy = new int[end - start + 1];


        int i = start + length;
        int j = end;
        int copyIndex = end - start;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (numbers[i] > numbers[j]) {
                copy[copyIndex--] = numbers[i--];
                count += j - start - length;
            } else {
                copy[copyIndex--] = numbers[j--];
            }
        }
        while (i >= start) {
            copy[copyIndex--] = numbers[i--];
        }

        while (j >= start + length + 1) {
            copy[copyIndex--] = numbers[j--];
        }

        for (int k = 0; k < end - start + 1; ++k) {
            numbers[start + k] = copy[k];
        }

        return count + left + right;

    }

    public static void main(String[] args) {
        int[] numbers0 = {7,5,6,4};
        int[] numbers1 = {4,2,3,4};
        int[] numbers2 = {6,6,4,2,1,7};
        System.out.println(inversePairs(numbers0));//5
        System.out.println(inversePairs(numbers1));//2
        System.out.println(inversePairs(numbers2));//9

    }
}
