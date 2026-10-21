// class Solution {
//     int[] cache;
//     public int climbStairs(int n) {
//         cache = new int[n + 1];
//         return dfs(n, 0);
//     }
    
//     private int dfs(int n, int i) {
//         if(i >= n) return i == n? 1 : 0;
//         if(cache[n] != 0) return cache[n];
//         return cache[n] = dfs(n, i + 1) + dfs(n, i + 2);
//     }
// }

class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        return dfs(n, 0);
    }
    
    private int dfs(int n, int i) {
        if(i > n) return 0;
        if(i == n) return 1;
        if(cache.containsKey(i)) return cache.get(i);
        int res = dfs(n, i + 1) + dfs(n, i + 2);
        cache.put(i, res);
        return res;
    }
}
