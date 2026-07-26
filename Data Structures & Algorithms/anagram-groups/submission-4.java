class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String key = mapAlpha(str);
            if(!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                map.get(key).add(str);
            }
        }
        System.out.println(map);
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
