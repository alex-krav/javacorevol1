package horstman.core.java.vol1.ch03;

import java.util.Arrays;

public class MultiDimensionalArrays {
    public static void main(String[] args) {
        int[][] magicSquare = {
                {16,3,2,13},
                {5,10,11,8},
                {9,6,7,12},
                {4,15,14,1},
        };
        System.out.println(Arrays.deepToString(magicSquare));
    }
}
