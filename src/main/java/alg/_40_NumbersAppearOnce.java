package alg;

public class _40_NumbersAppearOnce {

    public static void findNumbersAppearOnce(int[] numbers, int[] a, int[] b) {
        if (numbers == null || numbers.length < 2)
            return;

        int temp = 0;
        for (int i = 0; i < numbers.length; ++i) {
            temp ^= numbers[i];
        }
//        System.out.println(temp);

        int N = findFirstBit1(temp);
//        System.out.println(N);
        int n = (1 << N);
//        System.out.println(n);
        for (int i = 0; i < numbers.length; ++i) {
            if ((numbers[i] & n) == 0)
                a[0] ^= numbers[i];
            else
                b[0] ^= numbers[i];
        }

    }


    public static int findFirstBit1(int number) {
        if (number == 0) {
            return 0;
        }
        for (int i = 0; i < 32; ++i) {
            if ((number & 1) == 1)
                return i;
            number >>= 1;
        }

        return 0;
    }


    public static void main(String[] args) {
        int[] numbers = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] a = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] b = {0, 0, 0, 0, 0, 0, 0, 0};
        findNumbersAppearOnce(numbers, a, b);
        System.out.println(a[0]);
        System.out.println(b[0]);
    }


}
