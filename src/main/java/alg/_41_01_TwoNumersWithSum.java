package alg;

public class _41_01_TwoNumersWithSum {

    public static boolean findNumbersWithSum(int[] numbers, int num) {
        if (numbers == null || numbers.length < 2)
            return false;
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int temp = numbers[low] + numbers[high];
            if (temp > num)
                --high;
            if (temp < num)
                ++low;
            if (temp == num)
                return true;
        }

        return false;
    }


    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 7, 11, 15};
        int number = 15;
        System.out.println(findNumbersWithSum(numbers, number));

        int[] numbers2 = {1, 2, 3, 7, 11, 15};
        System.out.println(findNumbersWithSum(numbers2, number));

    }
}
