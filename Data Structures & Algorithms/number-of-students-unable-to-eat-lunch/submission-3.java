class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int res = sandwiches.length;
        int[] freq = new int[2];
        for(int s : students) {
            freq[s]++;
        }
        for(int s : sandwiches) {
            if(freq[s] == 0) {
                return res;
            }
            freq[s]--;
            res--;
        }
        return 0;
    }
}
