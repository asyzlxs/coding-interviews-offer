package alg;

public class _49_StringToInt {

    public boolean isValid = false;

    public int stringToInt(String str) {
        if (str == null || str.trim().length() < 1)
            return 0;

        str = str.trim();
        boolean isPositive = true;
        int index = 0;
        long result = 0;

        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            ++index;
            if (str.length() == 1)
                return 0;
            else if (str.charAt(0) == '-')
                isPositive = false;
        }


        for (int i = index; i < str.length(); ++i) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                return 0;
            result *= 10;

            result += ((str.charAt(i) - '0') * (isPositive ? 1 : -1));

        }

        isValid = true;

        return (int) result;


    }


    public static void main(String[] args) {
        String str1 = "+123";
        String str2 = "-123";
        String str3 = "123";
        _49_StringToInt sti = new _49_StringToInt();

        System.out.println(sti.stringToInt(str1));
        System.out.println(sti.stringToInt(str2));
        System.out.println(sti.stringToInt(str3));


    }
}
