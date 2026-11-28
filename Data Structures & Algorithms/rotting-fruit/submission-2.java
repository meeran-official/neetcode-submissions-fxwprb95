class Solution {
    public int orangesRotting(int[][] grid) {
        int minute = 0;
        Set<String> visit = new HashSet<>();
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(visit.contains(r + "," + c) || grid[r][c] != 2) continue;
                minute += bfs(grid, r, c, visit);
            }
        }
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == 1 && !visit.contains(r + "," + c)) return -1;
            }
        }
        return minute;
    }
    private int bfs(int[][] grid, int r, int c, Set<String> visit) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c, 0});
        visit.add(r + "," + c);
        int minute = 0;
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            r = cell[0]; c = cell[1];
            minute = cell[2];
            for(int[] n : neig()) {
                int dr = r + n[0], dc = c + n[1];
                if(invalid(grid, dr, dc, visit)) continue;
                visit.add(dr + "," + dc);
                if(grid[dr][dc] == 2) continue;
                q.offer(new int[] {dr, dc, minute + 1});
            }
        }
        return minute;
    }
    private boolean invalid(int[][] grid, int r, int c, Set<String> visit) {
        return Math.min(r, c) < 0 || r == grid.length || c == grid[0].length 
            || grid[r][c] == 0
            || visit.contains(r + "," + c);
    }
    private int[][] neig(){
        return new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    } 
}
