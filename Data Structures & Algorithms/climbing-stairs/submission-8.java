class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n + 1];
        return dfs(n, 0);
    }
    
    private int dfs(int n, int i) {
        if(i >= n) return i == n? 1 : 0;
        if(cache[i] != 0) return cache[i];
        return cache[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }
}
