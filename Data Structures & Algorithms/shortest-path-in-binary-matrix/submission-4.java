class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        if(grid[R - 1][C - 1] == 1 || grid[0][0] == 1) return -1;
        // boolean[][] visit = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();
        // visit[0][0] = true;
        q.offer(new int[] {0, 0, 1});
        grid[0][0] = 1;
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int r = arr[0], c = arr[1];
            if(r == R - 1 && c == C - 1) return grid[r][c];
            for(int[] n : neig()) {
                int dr = r + n[0], dc = c + n[1];
                if(invalid(grid, dr, dc, R, C)) continue;
                q.offer(new int[] {dr, dc});
                grid[dr][dc] = grid[r][c] + 1;
                // visit[dr][dc] = true;
            }
        }
        return -1;
    }
    private boolean invalid(int[][] grid, int r, int c, int R, int C) {
        return Math.min(r, c) < 0 || r == R || c == C
            || grid[r][c] > 0;
    }
    private int[][] neig() {
        return new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    }
}