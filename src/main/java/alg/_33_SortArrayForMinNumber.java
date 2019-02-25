package alg;

import java.util.Comparator;
import java.util.TreeSet;

public class _33_SortArrayForMinNumber {
    public static String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return null;
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1) > 0 ? 1 : -1;
            }

        });

        for (int i : numbers)
            set.add(String.valueOf(i));
        StringBuilder sb = new StringBuilder();
        for (String s : set)
            sb.append(s);

        return sb.toString();
    }


    public static void main(String[] args) {
        int[] numbers = {3,32,321};
        System.out.println(printMinNumber(numbers));
    }
}
