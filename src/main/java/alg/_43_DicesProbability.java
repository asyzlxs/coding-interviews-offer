package alg;

public class _43_DicesProbability {

    public static void printProbability(int number) {
        int maxValue = 6;
        if (number < 1) return;

        int[][] prob = new int[2][maxValue * number + 1];
        int flag = 0;

        for (int i = 1; i <= maxValue; ++i) {
            prob[flag][i] = 1;
        }

        for (int k = 2; k <= number; ++k) {
            for (int i = 0; i < k; ++i) {
                prob[1 - flag][i] = 0;
            }

            for (int i = k; i <= number * maxValue; ++i) {
                prob[1-flag][i] = 0;
                for (int j = 1; j <= i && j <= maxValue; ++j) {
                    prob[1 - flag][i] += prob[flag][i - j];
                }
            }

            flag = 1 - flag;
        }

        double total = Math.pow((double) maxValue, (double) number);
        double sum = 0.0;

        for (int i = number; i <= maxValue * number; ++i) {
            System.out.println(i + ":" + (prob[flag][i] / total));
            sum += (prob[flag][i] / total);
        }
        System.out.println("  " + sum);
    }


    public static void main(String[] args) {
        printProbability(6);


    }
}
