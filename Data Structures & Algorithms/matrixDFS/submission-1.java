class Solution {
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0, new HashSet<>());
    }
    private int dfs(int[][] grid, int r, int c, Set<String> visited) {
        int ROW = grid.length;
        int COL = grid[0].length;
        if(Math.min(r, c) < 0
            || c == COL || r == ROW
            || grid[r][c] == 1
            || visited.contains(r + "," + c)) {
            return 0;
        } else if(r == ROW - 1 && c == COL - 1) {
            return 1;
        }
        visited.add(r + "," + c);
        int count = 0;
        count += dfs(grid, r - 1, c, visited);
        count += dfs(grid, r + 1, c, visited);
        count += dfs(grid, r, c - 1, visited);
        count += dfs(grid, r, c + 1, visited);
        visited.remove(r + "," + c);
        return count;
    }
}
