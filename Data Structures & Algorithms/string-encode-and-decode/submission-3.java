class Solution {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str : strs) {
            res.append(str.length()).append('#').append(str);
        }
        return res.toString();
    }
    //5#HELLO5#adsf..
    public List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
