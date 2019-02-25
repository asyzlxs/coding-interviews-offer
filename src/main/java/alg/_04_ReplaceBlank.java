package alg;

public class _04_ReplaceBlank {
    /**
     * 题目:请实现一个函数，把字符串中的每个空格替换成"%20"。
     * 例如输入"We are happy.",则输出"We%20are%20happy."
     */

    public static String replaceBlank(StringBuffer str) {
        int oldLen = str.length();
        int len = oldLen;
        for (int i = 0; i < oldLen - 1; ++i) {
            if (str.charAt(i) == ' ')
                len += 2;
        }
        str.setLength(len);

        int j = len - 1;
        for (int i = oldLen - 1; i >= 0; ) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
                --i;
            } else {
                str.setCharAt(j--, str.charAt(i--));
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str1 = new StringBuffer("We are happy.");
        System.out.println(replaceBlank(str1));
    }
}
