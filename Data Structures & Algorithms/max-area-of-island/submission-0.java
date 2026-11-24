class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0, maxCount = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == 0) continue;
                count = dfs(grid, r, c);
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
    private int dfs(int[][] grid, int r, int c) {
        if(Math.min(r, c) < 0 || r == grid.length
        || c == grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int count = 0;
        count += dfs(grid, r + 1, c);
        count += dfs(grid, r - 1, c);
        count += dfs(grid, r, c + 1);
        count += dfs(grid, r, c - 1);
        return count + 1;
    }
}
