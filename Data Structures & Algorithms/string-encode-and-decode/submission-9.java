class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0) return "";
        StringBuilder res = new StringBuilder();
        for(String str : strs) {
            res.append(str.length()).append(str);
        }
        System.out.println("encode: res: " + res.toString());
        return res.toString();
    }

    public List<String> decode(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb;
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < chars.length) {
            sb = new StringBuilder();
            int k = Character.getNumericValue(chars[i]);
            while(k-- > 0) {
                sb.append(chars[i++]);
            }
            res.add(sb.toString());
            break;
        }
        System.out.println("decode: res: " + res);
        return res;
    }
}
