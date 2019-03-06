package alg;

public class _41_02_ContinuesSquenceWithSum {

    public static void findContinuesSequence(int num) {
        if (num < 3) return;
        int small = 1;
        int big = 2;
        int currentSum = big + small;
        while (small < ((num + 1) / 2)) {
            if (currentSum == num)
                printContinuousSequence(small, big);
            while (currentSum > num && small < ((num + 1) / 2)) {
                currentSum -= small;
                ++small;
                if (currentSum == num)
                    printContinuousSequence(small, big);
            }

            ++big;
            currentSum += big;
        }

    }


    public static void printContinuousSequence(int small, int big) {
        if(small >= big) return;
        for(int i=small ; i<=big;++i)
            System.out.print(i + " ");
        System.out.println();

    }

    public static void main(String[] args) {
        findContinuesSequence(15);
    }
}
