class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();

        for(int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        List<int[]> listArr = new ArrayList();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            listArr.add(new int[] {entry.getKey(), entry.getValue()});
        }

        listArr.sort((a,b) -> b[1] - a[1]);
        
        int[] res = new int[k];

        for(int i = 0; i < k; i++) {
            res[i] = listArr.get(i)[0];
        }

        return res;
    }
}
