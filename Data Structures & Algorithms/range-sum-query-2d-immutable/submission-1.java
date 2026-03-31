class NumMatrix {
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        int prefix;

        for(int r = 0; r < matrix.length; r++) {
            prefix = 0;
            for(int c = 0; c < matrix[0].length; c++) {
                prefix += matrix[r][c];
                matrix[r][c] = prefix;
            }
        }

        for(int c = 0; c < matrix[0].length; c++) {
            prefix = 0;
            for(int r = 0; r < matrix.length; r++) {
                prefix += matrix[r][c];
                matrix[r][c] = prefix;
            }
        }

        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0) {
            return matrix[row2][col2];
        } else if (row1 == 0) {
            return matrix[row2][col2] - matrix[row2][col1-1];
        } else if (col1 == 0) {
            return matrix[row2][col2] - matrix[row1-1][col2];
        }

        return matrix[row2][col2] - matrix[row2][col1-1] - matrix[row1-1][col2] + matrix[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);

    [3, 0, 1, 4, 2] 3   3   4   8   10
    [5, 6, 3, 2, 1] 5   11  14  16  17
    [1, 2, 0, 1, 5]
    [4, 1, 0, 1, 7]
    [1, 0, 3, 0, 5]

        0   1   2
    0   1   2   3       1   3   6       1   3   6
    1   4   5   6   =>  4   9   15  =>  5   12  21
    2   3   4   2       3   7   9       8   19  30

        

    RjCj - RjC[i-1] - R[i-1]Cj + R[i-1]C[j-1]

    *ci != 0, ri !=0

    (R1,C1 - R2,C2)

    1   2   3
    5   7   9
    8   11  11
                        

 */