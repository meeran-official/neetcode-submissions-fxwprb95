class Solution {
    public int shortestPath(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        Set<String> visit = new HashSet<>();
        visit.add("0,0");
        int len = 0;
        while(!q.isEmpty()) {
            for(int i = q.size(); i > 0; i--) {
                int[] pair = q.poll();
                int r = pair[0], c = pair[1];
                if(r == grid.length - 1 && c == grid[0].length - 1) return len;
                for(int[] n : new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                    int dr = r + n[0], dc = c + n[1];
                    if(invalid(grid, dr, dc, visit)) continue;
                    q.offer(new int[] {dr, dc});
                    visit.add(dr + "," + dc);
                }
            }
            len++;
        }
        return -1;
    }
    private boolean invalid(int[][] grid, int r, int c, Set<String> visit) {
        return Math.min(r, c) < 0 || r == grid.length || c == grid[0].length
            || visit.contains(r + "," + c) || grid[r][c] == 1;
    }
}
