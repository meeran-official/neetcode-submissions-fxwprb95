class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        return dfs(n, 0);
    }
    
    private int dfs(int n, int i) {
        if(i > n) return 0;
        if(i == n) return 1;
        return dfs(n, i + 1) + dfs(n, i + 2);
    }
}
