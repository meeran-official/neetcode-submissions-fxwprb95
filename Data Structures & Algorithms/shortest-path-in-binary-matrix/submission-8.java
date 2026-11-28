class Solution {
    int R, C;
    public int shortestPathBinaryMatrix(int[][] grid) {        
        R = grid.length; C = grid[0].length;
        if(grid[0][0] == 1 && grid[R - 1][C - 1] == 1) return -1;
        if(grid.length == 1) return 1;
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        q1.offer(new int[] {0, 0});
        q2.offer(new int[] {R - 1, C - 1});
        grid[0][0] = -1;
        grid[R - 1][C - 1] = -2;
        int start = -1, end = -2, res = 2;
        while(!q1.isEmpty() && !q2.isEmpty()) {
            for(int i = q1.size(); i > 0; i--) {
                int[] cell = q1.poll();
                int r = cell[0], c = cell[1];
                for(int[] n : neig()) {
                    int dr = r + n[0], dc = c + n[1];
                    if(Math.min(dr, dc) < 0 || dr == R || dc == C) continue;
                    if(grid[dr][dc] == end) return res;
                    if(grid[dr][dc] != 0) continue;
                    grid[dr][dc] = start;
                    q1.offer(new int[] {dr, dc});
                }
            }
            // swap(q1, q2);
            Queue<int[]> t = q1;
            q1 = q2;
            q2 = t;
            int[] s = swap(start, end);
            start = s[0]; end = s[1];
            res++;
            System.out.println("res: " + res);
        }
        return -1;
    }
    private int[] swap(int x, int y) {       
        return new int[] {y, x};
    }
    private void swap(Queue<int[]> q1, Queue<int[]> q2) {
        Queue<int[]> t = q1;
        q1 = q2;
        q2 = t;
    }
    private int[][] neig() {
        return new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    }
}