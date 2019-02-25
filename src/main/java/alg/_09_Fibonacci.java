package alg;

public class _09_Fibonacci {

    public static long fibonacci(int N) {
        int[] data = {0, 1};
        if (N < 2) {
            return data[N];
        }
        int fibonacci_one = data[1];
        int fibonacci_two = data[0];
        int fibonacci_ = 0;
        for (int i = 2; i <= N; ++i) {
            fibonacci_ = fibonacci_one + fibonacci_two;
            fibonacci_two = fibonacci_one;
            fibonacci_one = fibonacci_;
        }
        return fibonacci_;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(30));
    }


}
