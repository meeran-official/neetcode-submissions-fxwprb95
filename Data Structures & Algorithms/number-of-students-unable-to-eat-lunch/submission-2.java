class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = sandwiches.length;
        for(int s : students) {
            map.merge(s, 1, Integer::sum);
        }
        for(int s : sandwiches) {

            if(!map.containsKey(s) || map.get(s) == 0) {
                return res;
            }
            map.merge(s, -1, Integer::sum);
            res--;
        }
        return 0;
    }
}
