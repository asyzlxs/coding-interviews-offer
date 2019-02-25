package alg;

public class _34_UglyNumber {

    public static int getUglyNumber(int k) {
        int[] uglyNumbers = new int[k];
        uglyNumbers[0] = 1;
        int uglyNumberIndex = 1;
        int uglyNumberIndex2 = 0;
        int uglyNumberIndex3 = 0;
        int uglyNumberIndex5 = 0;
        int currentMin = 1;
        while (uglyNumberIndex < k) {
            currentMin = min(uglyNumbers[uglyNumberIndex2] * 2, uglyNumbers[uglyNumberIndex3] * 3, uglyNumbers[uglyNumberIndex5] * 5);
            uglyNumbers[uglyNumberIndex++] = currentMin;
            if (uglyNumbers[uglyNumberIndex2] * 2 == currentMin)
                ++uglyNumberIndex2;
            if (uglyNumbers[uglyNumberIndex3] * 3 == currentMin)
                ++uglyNumberIndex3;
            if (uglyNumbers[uglyNumberIndex5] * 5 == currentMin)
                ++uglyNumberIndex5;
        }
        return uglyNumbers[k - 1];
    }

    public static int min(int a, int b, int c) {
        int min = ((a - b) > 0 ? b : a);
        min = ((min - c) > 0 ? c : min);
        return min;
    }


    public static void main(String[] args) {
        System.out.println(getUglyNumber(1));
        System.out.println(getUglyNumber(2));
        System.out.println(getUglyNumber(3));
        System.out.println(getUglyNumber(4));
        System.out.println(getUglyNumber(5));
        System.out.println(getUglyNumber(1500));
    }
}
