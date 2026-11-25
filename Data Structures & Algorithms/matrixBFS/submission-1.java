class Solution {
    Set<String> visit;
    public int shortestPath(int[][] grid) {
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
                // int r2 = r + 1, c2 = c;
                // if(!invalid(grid, r2, c2)) {
                //     queue.offer(new int[] {r2, c2});
                //     visit.add(r2 + "," + c2);
                // }
                // r2 = r - 1;
                // c2 = c;
                // if(!invalid(grid, r2, c2)) {
                //     queue.offer(new int[] {r2, c2});
                //     visit.add(r2 + "," + c2);
                // }
                // r2 = r;
                // c2 = c + 1;
                // if(!invalid(grid, r2, c2)) {
                //     queue.offer(new int[] {r2, c2});
                //     visit.add(r2 + "," + c2);
                // }
                // r2 = r;
                // c2 = c - 1;
                // if(!invalid(grid, r2, c2)) {
                //     queue.offer(new int[] {r2, c2});
                //     visit.add(r2 + "," + c2);
                // }
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
