class Solution {
    Set<String> visit;
    public int shortestPath(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
         if (grid[0][0] == 1 || grid[ROWS - 1][COLS - 1] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        visit = new HashSet<>();
        queue.offer(new int[] {0, 0});
        visit.add(0 + "," + 0);
        int len = 0;
        while(!queue.isEmpty()) {
            for(int i = queue.size(); i > 0; i--) {
                int[] idx = queue.poll();
                int r = idx[0], c = idx[1];
                if(r == grid.length - 1 && c == grid[0].length - 1) {
                    return len;
                }
                int[][] neighs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for(int[] neigh : neighs) {
                    int dr = neigh[0], dc = neigh[1];
                    if(invalid(grid, r + dr, c + dc)) continue;                    
                    queue.offer(new int[] {r + dr, c + dc});
                    visit.add((r + dr) + "," + (c + dc));
                }
            }
            len++;
        }
        return -1;
    }
    private boolean invalid(int[][] grid, int r, int c) {
        return Math.min(r, c) < 0 || r == grid.length
                || c == grid[0].length || visit.contains(r + "," + c)
                || grid[r][c] == 1;
    }
}
