/*
    if strs is empty return early
    if strs length is 1, return
    Initialize a map of string to list
    Loop strs as str
        If sorted str doesn't present in map key, add the sorted as key and original as value
        else append the original value to the existing key
    return map values as list


["act","pots","tops","cat","stop","hat"]

"act" -> "act", "cat"
"opst" -> "pots", "tops", "stop"
"aht" -> "hat"
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // if(strs.length == 0) return new Arrays.asList(Arrays.asList(""));
        // if(strs.length == 1) return new Arrays.asList(Arrays.asList(strs[0]));
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
