class Solution {
    public int removeDuplicates(int[] nums) {
        
        Map<Integer, Boolean> memory = new HashMap();
        
        int ptrOne = 0;
        int ptrTwo = 0;
        
        boolean uniqueElemFound;

        while(ptrOne < nums.length) {

            if(memory.containsKey(nums[ptrOne])) {

                if(ptrTwo <= ptrOne) {
                    ptrTwo = ptrOne + 1; 
                }

                uniqueElemFound = false;

                while(ptrTwo < nums.length) {
                    if(!memory.containsKey(nums[ptrTwo])) {
                        uniqueElemFound = true;
                        break;
                    }

                    ptrTwo++;
                }

                if(!uniqueElemFound) {
                    break;
                }

                nums[ptrOne] = nums[ptrTwo];
            }

            memory.put(nums[ptrOne], true);

            ptrOne++;
        }

        return memory.keySet().size();
    }
}