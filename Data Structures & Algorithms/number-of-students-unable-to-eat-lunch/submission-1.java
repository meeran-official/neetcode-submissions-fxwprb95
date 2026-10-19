class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int s : students) {
            map.merge(s, 1, Integer::sum);
        }
        for(int s : sandwiches) {
            if(!map.containsKey(s) || map.get(s) == 0) {
                if(s == 0) {
                    return map.get(1);
                }
                return map.get(0);
            }
            map.merge(s, -1, Integer::sum);
        }
        return 0;
    }
}