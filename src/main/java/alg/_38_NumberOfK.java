package alg;

public class _38_NumberOfK {

    public static int getNumberOfK(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0) return 0;
        int start = getFirstK(numbers, k);
        int end = getLastK(numbers, k);
        if (start == -1) return 0;

        return end - start + 1;
    }

    private static int getLastK(int[] numbers, int k) {
        int low = 0;
        int high = numbers.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (numbers[mid] == k) {
                if (mid < high && numbers[mid + 1] > k)
                    return mid;
                else if (mid == high)
                    return mid;
                else
                    low = mid + 1;
            } else if (numbers[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private static int getFirstK(int[] numbers, int k) {
        int low = 0;
        int high = numbers.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (numbers[mid] == k) {
                if (mid > low && numbers[mid - 1] < k)
                    return mid;
                else if (mid == low)
                    return mid;
                else
                    high = mid - 1;
            } else if (numbers[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(numbers, 3));
        int[] arr = new int[]{1, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8};
        int n = getNumberOfK(arr, 3);
        equal(n, 5);

        n = getNumberOfK(arr, 4);
        //System.out.println(n);
        equal(n, 3);

        n = getNumberOfK(arr, 5);
        //System.out.println(n);
        equal(n, 2);

        n = getNumberOfK(arr, 6);
        equal(n, 1);

        n = getNumberOfK(arr, 11);
        equal(n, 0);

    }


    public static void equal(int v1, int v2) {
        if (v1 == v2) {
            System.out.println("ok");
        } else {
            System.out.println("error");
        }
    }
}
