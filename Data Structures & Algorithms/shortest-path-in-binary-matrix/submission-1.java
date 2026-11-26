class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROW = grid.length, COL = grid[0].length;
        if(grid[ROW - 1][COL - 1] == 1 || grid[0][0] == 1) return -1;
        Set<String> visit = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        visit.add("0,0");
        q.offer(new int[] {0, 0});
        int len = 0;
        while(!q.isEmpty()) {
            for(int i = q.size(); i > 0; i--) {
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];
                if(r == ROW - 1 && c == COL - 1) return len + 1;
                for(int[] n : neig()) {
                    int dr = r + n[0], dc = c + n[1];
                    if(invalid(grid, dr, dc, ROW, COL, visit)) continue;
                    q.offer(new int[] {dr, dc});
                    visit.add(dr + "," + dc);
                }
            }
            len++;
        }
        return -1;
    }
    private boolean invalid(int[][] grid, int r, int c, int ROW, int COL, Set<String> visit) {
        return Math.min(r, c) < 0 || r == ROW || c == COL
            || visit.contains(r + "," + c) || grid[r][c] == 1;
    }
    private int[][] neig() {
        return new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    }
}