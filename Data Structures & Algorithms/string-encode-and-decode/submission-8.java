class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0) return "";
        if(strs.size() == 1) return strs.get(0);
        String delim = "$#";
        StringBuilder res = new StringBuilder();
        for(String str : strs) {
            res.append(str).append(delim);
        }
        System.out.println("encode: res: " + res.toString());
        return res.toString();
    }

    public List<String> decode(String str) {
        String delim = "$#";
        String escape = "\\";
        String[] strs = str.split(escape + delim);
        System.out.println("decode: strs: " + Arrays.toString(strs));
        List<String> res = new ArrayList<>();
        for(String s : strs) {
            res.add(s);
        }
        return res;
    }
}
