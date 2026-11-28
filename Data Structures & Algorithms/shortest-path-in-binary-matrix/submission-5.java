class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[grid.length - 1][grid[0].length - 1] == 1 || grid[0][0] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 1});
        grid[0][0] = 1;
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int r = arr[0], c = arr[1];
            if(r == grid.length - 1 && c == grid[0].length - 1) return grid[r][c];
            for(int[] n : neig()) {
                int dr = r + n[0], dc = c + n[1];
                if(invalid(grid, dr, dc)) continue;
                q.offer(new int[] {dr, dc});
                grid[dr][dc] = grid[r][c] + 1;
            }
        }
        return -1;
    }
    private boolean invalid(int[][] grid, int r, int c) {
        return Math.min(r, c) < 0 || r == grid.length || c == grid[0].length
            || grid[r][c] > 0;
    }
    private int[][] neig() {
        return new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    }
}