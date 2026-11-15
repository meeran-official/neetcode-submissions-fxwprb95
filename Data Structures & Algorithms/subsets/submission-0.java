class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }
    private void dfs(int[] nums, int i, List<Integer> subSet, List<List<Integer>> res) {
        if(i == nums.length) {
            res.add(subSet);
            return;
        }
        List<Integer> newSet = new ArrayList<>(subSet);
        newSet.add(nums[i]);
        dfs(nums, i + 1, newSet, res);
        dfs(nums, i + 1, subSet, res);
    }
}
