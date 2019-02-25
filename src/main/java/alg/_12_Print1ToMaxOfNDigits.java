package alg;

public class _12_Print1ToMaxOfNDigits {

    public static void Print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] numbers = new char[n];
        Print1ToMaxOfDigitsRecursively(numbers, n - 1);

    }

    public static void Print1ToMaxOfDigitsRecursively(char[] numbers, int index) {
        if (index == -1) {
            PrintNumber(numbers);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            numbers[index] = (char) ('0' + i);
            Print1ToMaxOfDigitsRecursively(numbers, index - 1);
        }

    }

    public static void PrintNumber(char[] numbers) {
        boolean zeroFlag = true;
        for (int i = numbers.length - 1; i >= 0; --i) {
            if (numbers[i] == '0' && zeroFlag)
                continue;
            System.out.print(numbers[i]);
            zeroFlag = false;
        }

        if (!zeroFlag) {
            System.out.print(' ');
        }
    }


    public static void main(String[] args) {
        Print1ToMaxOfNDigits(3);
    }

}
