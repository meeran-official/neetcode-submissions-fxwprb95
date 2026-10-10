class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] mat) {
        this.mat = mat;
        update(mat);
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        int res = mat[r2][c2];
        if(r1 > 0) res -= mat[r1 - 1][c2];
        if(c1 > 0) res -= mat[r2][c1 - 1];
        if(r1 > 0 && c1 > 0) res += mat[r1 - 1][c1 - 1];
        return res;
    }

    private void update(int[][] mat) {
        for(int r = 0; r < mat.length; r++) {
            int runSum = 0;
            for(int c = 0; c < mat[0].length; c++) {
                runSum += mat[r][c];
                mat[r][c] = runSum;
            }
        }
        for(int c = 0; c < mat[0].length; c++) {
            int runSum = 0;
            for(int r = 0; r < mat.length; r++) {
                runSum += mat[r][c];
                mat[r][c] = runSum;
            }
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(mat);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */