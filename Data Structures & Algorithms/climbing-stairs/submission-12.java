class Solution {
    public int climbStairs(int n) {
        return fetchResult(n);
    }

    private int[][] matrixProd(int[][] A, int[][] B) {
        return new int[][] {
            { A[0][0] * B[0][0] + A[0][1] * B[1][0], A[0][0] * B[0][1] + A[0][1] * B[1][1] },
            { A[1][0] * B[0][0] + A[1][1] * B[1][0], A[1][0] * B[0][1] + A[1][1] * B[1][1] }
        };
    }

    private int fetchResult(int n) {
        int[][] res = new int[][] {
            {1, 0},
            {0, 1}
        };
        int[][] base = new int[][] {
            {1, 1},
            {1, 0}
        };
        while(n > 0) {
            if(n % 2 == 1) {
                res = matrixProd(res, base);
            }
            base = matrixProd(base, base);
            n /= 2;
        }
        return res[0][0];
    }
}
