package alg;

public class VerifySequenceOfBST {

    public static boolean verifySequenceOFBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;

        return verifySequenceOFBST(sequence, 0, sequence.length - 1);
    }


    public static boolean verifySequenceOFBST(int[] sequence, int start, int end) {

        int cut = start;
        int root = sequence[end];
        for (; cut < end; ++cut) {
            if (sequence[cut] > root) {
                break;
            }
        }
        int pos = cut - 1;

        for (; cut < end; ++cut) {
            if (sequence[cut] < root) {
                return false;
            }
        }

        boolean left = true;
        if (pos > start)
            left = verifySequenceOFBST(sequence, start, pos);
        boolean right = true;
        if (pos < end - 1)
            right = verifySequenceOFBST(sequence, pos + 1, end - 1);

        return (left && right);

    }

    public static void main(String[] args) {
        int[] sequence1= {5,7,6,9,11,10,8};
        int[] sequence2= {7,4,6,5};

        System.out.println(verifySequenceOFBST(sequence1));
        System.out.println(verifySequenceOFBST(sequence2));

    }


}
