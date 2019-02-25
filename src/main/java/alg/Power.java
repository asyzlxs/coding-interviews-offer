package alg;

public class Power {

    public static double power(double base, int exponment) {
        if (equal(base, 0.0) && exponment <= 0)
            return 0.0;

        double result = 1.0;
        if (exponment >= 0)
            result = powerWithExponment(base, exponment);
        else
            result = 1 / powerWithExponment(base, -exponment);
        return result;
    }

    public static double powerWithExponment(double base, int exponment) {
        if (exponment == 1)
            return base;
        if (exponment == 0)
            return 1.0;
        double result = powerWithExponment(base, exponment / 2);
        result *= result;
        if (exponment % 2 == 1)
            result *= base;
        return result;
    }

    public static boolean equal(double num1, double num2) {
        return (num1 - num2) > -0.0000001 && (num1 - num2) < 0.0000001;
    }

    public static void main(String[] args) {
        System.out.println(power(5.0,2));
        System.out.println(power(0.0,2));
        System.out.println(power(2.0,9));

    }
}
