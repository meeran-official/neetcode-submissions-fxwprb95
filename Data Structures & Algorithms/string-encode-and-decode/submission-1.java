class Solution {

    public String encode(List<String> strs) {
        char delim = '#';

        StringBuilder res = new StringBuilder();

        for(String str : strs) {
            res.append(str.length()).append(delim).append(str);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        char delim = '#';

        char[] chars = str.toCharArray();

        StringBuilder numStr = new StringBuilder();
        StringBuilder build = new StringBuilder();

        int i = 0;
        int num;

        List<String> res = new ArrayList<>();

        while(i < str.length()) {
            numStr.setLength(0);
            while(chars[i] != delim) numStr.append(chars[i++]);
            
            i++;

            num = Integer.parseInt(numStr.toString());

            build.setLength(0);
            int target = i + num;
            while(i < target) build.append(chars[i++]);

            res.add(build.toString());
        }

        return res;
    }
}
