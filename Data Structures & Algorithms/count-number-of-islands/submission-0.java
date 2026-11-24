class Solution {
    public int numIslands(char[][] grid) {
        Set<String> visit = new HashSet<>();
        int count = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == '0' || visit.contains(r + "," + c)) continue;
                dfs(grid, r, c, visit);
                count++;
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int r, int c, Set<String> visit) {
        int ROW = grid.length, COL = grid[0].length;
        if(Math.min(r, c) < 0 || r == ROW || c == COL 
        || visit.contains(r + "," + c)
        || grid[r][c] == '0') {
            return;
        }
        visit.add(r + "," + c);
        dfs(grid, r + 1, c, visit);
        dfs(grid, r - 1, c, visit);
        dfs(grid, r, c + 1, visit);
        dfs(grid, r, c - 1, visit);
    }
}
