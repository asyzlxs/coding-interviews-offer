package alg;

public class _31_GreatestSumOfSubarrays {


    public static int findGreatestSumOfSubarrays(int[] numbers) {
        int sum = Integer.MIN_VALUE;
        int current = 0;
        for (int i = 0; i < numbers.length; ++i) {
            if (current <= 0)
                current = numbers[i];
            else
                current += numbers[i];
            if (current > sum)
                sum = current;
        }
        return sum;
    }


    public static int findGreatestSumOfSubarrays_1(int[] numbers) {
        int sum = Integer.MIN_VALUE;
        int current = 0;
        for (int i = 0; i < numbers.length; ++i) {
            current += numbers[i];
            if (current > sum)
                sum = current;
            else {
                if (current < 0)
                    current = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findGreatestSumOfSubarrays(numbers));
        System.out.println(findGreatestSumOfSubarrays_1(numbers));
    }
}
