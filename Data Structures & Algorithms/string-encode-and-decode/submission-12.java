class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0) return "";
        StringBuilder res = new StringBuilder();
        for(String str : strs) {
            res.append(str.length()).append("$").append(str);
        }
        System.out.println("encode: res: " + res.toString());
        return res.toString();
    }

    public List<String> decode(String str) {
        char[] chars = str.toCharArray();
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < chars.length) {
            while(chars[i] != '$') {
                StringBuilder strLen = new StringBuilder();
                strLen.append(chars[i]);
                i++;
            }
            i++;
            int len = Integer.parseInt(strLen.toString());
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < len; j++) {
                sb.append(chars[i++]);
            }
            res.add(sb.toString());

        }
        System.out.println("decode: res: " + res);
        return res;
    }
}
