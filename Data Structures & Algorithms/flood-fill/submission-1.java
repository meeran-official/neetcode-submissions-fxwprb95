class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) return image;
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int origColor, int color) {
        int ROW = image.length;
        int COL = image[0].length;
        if(Math.min(r, c) < 0
            || r == ROW || c == COL
            || image[r][c] != origColor) {
            return;
        }
        image[r][c] = color;
        dfs(image, r - 1, c, origColor, color);
        dfs(image, r + 1, c, origColor, color);
        dfs(image, r, c - 1, origColor, color);
        dfs(image, r, c + 1, origColor, color);
    }
}