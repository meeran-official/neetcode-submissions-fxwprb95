class Solution {

    public String encode(List<String> strs) {
        String delim = "#";
        StringBuilder res = new StringBuilder();
        for(String str : strs) {
            res.append(str).append(delim);
        }
        System.out.println("encode: res: " + res.toString());
        return res.toString();
    }

    public List<String> decode(String str) {
        String delim = "#";
        String[] strs = str.split(delim);
        System.out.println("decode: strs: " + Arrays.toString(strs));
        List<String> res = new ArrayList<>();
        for(String s : strs) {
            res.add(s);
        }
        return res;
    }
}
