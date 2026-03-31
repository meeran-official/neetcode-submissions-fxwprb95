class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for(String str : strs) {
            int[] freq = new int[26];
            for(char c : str.toCharArray()) {
                freq[c - 'a']++;
            }
            map.computeIfAbsent(Arrays.toString(freq), k -> new ArrayList()).add(str);
        }
        return new ArrayList(map.values());
    }
}
