class Solution {
    //Algorithm: {length} + {delim} + {str}
    public String encode(List<String> strs) {
        char delim = '|';

        StringBuilder encoded = new StringBuilder();

        for(String str : strs) {
            encoded.append(str.length());
            encoded.append(delim);
            encoded.append(str);
        }

        return encoded.toString();
    }

    /*
        12|LongWording....5|World

        3|abc6|..
    */
    public List<String> decode(String str) {
        char delim = '|';
        char[] chars = str.toCharArray();

        int i = 0;

        StringBuilder lenBuild = new StringBuilder();
        StringBuilder strBuild = new StringBuilder();

        int len;
        int target;

        List<String> list = new ArrayList<>();

        while(i < str.length()) {
            lenBuild.setLength(0);

            while(chars[i] != delim) {
                lenBuild.append(chars[i++]);
            }
            i++;

            len = Integer.parseInt(lenBuild.toString());
            target = i + len;
            
            strBuild.setLength(0);

            while(i < target) {
                strBuild.append(chars[i++]);
            }

            list.add(strBuild.toString());
        }

        return list;
    }
}
