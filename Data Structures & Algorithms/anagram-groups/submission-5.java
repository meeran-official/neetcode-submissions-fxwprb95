class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String key = mapAlpha(str);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return map.values().stream().toList();
    }

    private String mapAlpha(String str) {
        int[] alpha = new int[26];
        for(char c : str.toCharArray()) {
            alpha[c - 'a']++;
        }
        return Arrays.toString(alpha);
    }
}
