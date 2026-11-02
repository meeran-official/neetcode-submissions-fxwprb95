class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = bSearchRow(0, matrix.length - 1, matrix, target);
        if(row == -1) return false;
        return bSearch(0, matrix[row].length - 1, matrix[row], target);
    }
    private boolean bSearch(int l, int r, int[] row, int target) {
        if(l > r) return false;
        int m = l + (r - l) / 2;
        if(target < row[m]) {
            return bSearch(l, m - 1, row, target);
        } else if(target > row[m]) {
            return bSearch(m + 1, r, row, target);
        } else {
            return true;
        }
    }
    private int bSearchRow(int l, int r, int[][] matrix, int target) {
        if(l > r) return -1;
        int m = l + (r - l) / 2;
        if(target < matrix[m][0]) {
            return bSearchRow(l, m - 1, matrix, target);
        } else if(target > matrix[m][matrix[m].length - 1]) {
            return bSearchRow(m + 1, r, matrix, target);
        } else {
            return m;
        }
    }
}
