package alg;

import java.util.ArrayList;
import java.util.TreeSet;

public class _28_StringPermutation {
//    private TreeSet<String> set;


    public static ArrayList<String> permutation(String str) {
        if (str == null || str.trim().length() == 0)
            return null;

        TreeSet<String> set = new TreeSet<>();
        char[] chars = str.toCharArray();
        permutation(chars, set,0);

        return new ArrayList<>(set);


    }

    public static void permutation(char[] chars, TreeSet<String> set,int index) {
        if (index == chars.length - 1){
            set.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; ++i) {
            swap(chars, index, i);
            permutation(chars, set,index+1);
            swap(chars, index, i);
        }

    }


    public static void swap(char[] chars, int ch1, int ch2) {
        char tmp = chars[ch1];
        chars[ch1] = chars[ch2];
        chars[ch2] = tmp;
    }


    public static void main(String[] args) {
        String str = "abc";
//        _28_StringPermutation strPerm = new _28_StringPermutation();
//        ArrayList<String> list = strPerm.permutation(str);
        ArrayList<String> list = permutation(str);
        System.out.println(list);
    }
}
