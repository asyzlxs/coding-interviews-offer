package alg;

public class _42_LeftRotateString {


    public static void reverse(char[] chars, int small, int big) {
        if (small >= big) return;
        while (small < big) {
            char temp = chars[big];
            chars[big] = chars[small];
            chars[small] = temp;
            ++small;
            --big;
        }
    }

    public static String leftRotateString(String str, int n) {
        if (str == null || str.length() <= n)
            return str;
        int length = str.length();
        char[] chars = str.toCharArray();
        int part1Begin = 0;
        int part1End = n - 1;
        int part2End = length - 1;
        reverse(chars, part1Begin, part1End);
        reverse(chars, n, part2End);
        reverse(chars, 0, length - 1);

        return String.valueOf(chars);

    }

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(leftRotateString(str, 2));
    }


}
