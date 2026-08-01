class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=0;
        while(j<nums.length){
            int value=nums[j];
            while(j<nums.length&&nums[j]==value){
                j++;
            }
            nums[i++]=value;
        }
        return i;
        
    }
}