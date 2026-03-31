class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] key;
        Map<String, List<String>> freq = new HashMap<>();

        for(String str : strs) {
            key = new int[26];
            
            for(char c : str.toCharArray()) {
                key[c - 'a']++;
            }        

            freq.computeIfAbsent(Arrays.toString(key), k -> new ArrayList<>()).add(str);
        }

        List<List<String>> res = new ArrayList<>();

        freq.forEach((k, v) -> {
            res.add(v);
        });

        return res;
    }
}
