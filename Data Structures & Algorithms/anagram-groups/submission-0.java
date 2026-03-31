class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        var map = new HashMap<String, List<String>>();
        
        for(String str : strs) {
            map.computeIfAbsent(sorted(str), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String sorted(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
