package alg;

public class _03_FindInPartiallySortedMatrix {
    /**
     * 题目：在一个二维数组中，每一行都按照从左到右的递增顺序排序，
     * 每一列都按照从上倒下的递增顺序排列。请完成一个函数输入这样
     * 的一个二维素组和一个整数，判断数组中是否含有该整数。
     * 1  2  8  9
     * 2  4  9 12
     * 4  7 10 13
     * 6  8 11 15
     */

    public static boolean findInPartiallySortedMatrix(int targe, int[][] numbers) {
        if (numbers == null) return false;
        int x = 0;
        int y = numbers[0].length - 1;
        while (x <= numbers.length - 1 && y >= 0) {
            if (numbers[x][y] > targe) {
                --y;
            } else if (numbers[x][y] < targe) {
                ++x;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrixNumbers = {{1, 2, 8, 9}, {2, 4, 9, 12},
                {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(findInPartiallySortedMatrix(5,matrixNumbers));
        System.out.println(findInPartiallySortedMatrix(7,matrixNumbers));
    }

}
