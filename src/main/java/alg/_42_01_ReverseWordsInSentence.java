package alg;

import java.util.Arrays;

public class _42_01_ReverseWordsInSentence {

    public static String reverseSentence(String str) {

        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int begin = 0;
        int end = 0;
        while (begin < chars.length && end < chars.length) {
            if (chars[end] == ' ') {
                reverse(chars, begin, end - 1);
                ++end;
                begin = end;
            } else {
                ++end;
            }
        }

        return String.valueOf(chars);

    }


    public static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
            ++i;
            --j;
        }
    }


    public static void main(String[] args) {
        String str = "I am a student.";

        System.out.println(reverseSentence(str));
    }


}
