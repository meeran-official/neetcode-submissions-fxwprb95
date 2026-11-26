class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        if(grid[R - 1][C - 1] == 1 || grid[0][0] == 1) return -1;
        boolean[][] visit = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();
        visit[0][0] = true;
        q.offer(new int[] {0, 0});
        int len = 0;
        while(!q.isEmpty()) {
            for(int i = q.size(); i > 0; i--) {
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];
                if(r == R - 1 && c == C - 1) return len + 1;
                for(int[] n : neig()) {
                    int dr = r + n[0], dc = c + n[1];
                    if(invalid(grid, dr, dc, R, C, visit)) continue;
                    q.offer(new int[] {dr, dc});
                    visit[dr][dc] = true;
                }
            }
            len++;
        }
        return -1;
    }
    private boolean invalid(int[][] grid, int r, int c, int R, int C, boolean[][] visit) {
        return Math.min(r, c) < 0 || r == R || c == C
            || visit[r][c] || grid[r][c] == 1;
    }
    private int[][] neig() {
        return new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    }
}