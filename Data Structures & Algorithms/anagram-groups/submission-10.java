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
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] count = new int[26];
            for(char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            map.computeIfAbsent(Arrays.toString(count), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
