class Solution {

    public static String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        for(String str : strs) {
            res.append(str.length()).append("#").append(str);
        }
        System.out.println("encode: res: " + res.toString());
        return res.toString();
    }

    public static List<String> decode(String str) {
        char[] chars = str.toCharArray();
        List<String> res = new ArrayList<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < chars.length) {
            sb.setLength(0);
            while(chars[i] != '#') {
                sb.append(chars[i]);
                i++;
            }
            i++;
            int len = Integer.parseInt(sb.toString());
            sb.setLength(0);
            for(int j = 0; j < len; j++) {
                sb.append(chars[i++]);
            }
            res.add(sb.toString());

        }
        System.out.println("decode: res: " + res);
        return res;
    }
}
