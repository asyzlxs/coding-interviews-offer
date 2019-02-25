package alg;

public class _08_MinNumberInRotatedArry {

    public static int min(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return 0;
        int index1 = 0;
        int index2 = numbers.length - 1;
        int midIndex = index1;
        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1)
                return numbers[index2];

            midIndex = index1 + (index2 - index1) / 2;
            if (numbers[index1] == numbers[index2] && numbers[index1] == numbers[midIndex])
                return minInOrder(numbers, index1, index2);

            if (numbers[index2] >= numbers[midIndex])
                index2 = midIndex;
            if (numbers[index1] <= numbers[midIndex])
                index1 = midIndex;

        }

        return numbers[midIndex];
    }

    public static int minInOrder(int[] numbers, int beginIndex, int endIndex) {
        int minNumber = numbers[beginIndex];
        for (int i = beginIndex + 1; i <= endIndex; ++i) {
            if (numbers[i] < minNumber)
                minNumber = numbers[i];
        }
        return minNumber;
    }


    public static void main(String[] args) {
        int[] test1 = {1,2,3,4,5,6,7};
        int[] test2 = {1,1,1,1,0,1,1};
        int[] test3 = {3,4,5,1,2,3,3};
        System.out.println(min(test1));
        System.out.println(min(test2));
        System.out.println(min(test3));
    }


}
