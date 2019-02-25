package alg;

import java.util.LinkedList;

public class _22_IsPopOrder {

    public static boolean isPopOrder(int[] pushStack, int[] popStack) {
        if (pushStack == null || popStack == null || pushStack.length != popStack.length) {
            return false;
        }

        LinkedList<Integer> list = new LinkedList<>();

        int popIndex = 0;
        for (int i = 0; i < pushStack.length; ++i) {
            list.addLast(pushStack[i]);
            if (list.getLast() == popStack[popIndex]) {
                list.removeLast();
                ++popIndex;
                while (!list.isEmpty()) {
                    if (list.getLast() == popStack[popIndex]) {
                        list.removeLast();
                        ++popIndex;
                        continue;
                    }
                    break;
                }
            }
        }

        if (popIndex == popStack.length && list.isEmpty())
            return true;

        return false;
    }

    public static void main(String[] args) {
        int[] pushStack = {1,2,3,4,5};
        int[] popStack1 = {4,5,3,2,1};
        int[] popStack2 = {4,3,5,1,2};
        System.out.println(isPopOrder(pushStack,popStack1));
        System.out.println(isPopOrder(pushStack,popStack2));


    }


}
