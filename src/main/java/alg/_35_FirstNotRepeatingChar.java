package alg;

import java.util.HashMap;

public class _35_FirstNotRepeatingChar {

    public static char firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return '0';
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : chars) {
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else {
                map.put(ch, 1);
            }
        }

        char result = '0';
        for (char ch : chars) {
            if (map.get(ch) == 1){
                result = ch;
                break;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("abaccdeff"));
    }
}
