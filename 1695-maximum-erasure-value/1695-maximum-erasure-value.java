class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int j=0;
        int sum=0;
        int maxSum=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            while(set.contains(nums[i])){
                set.remove(nums[j]);
                sum -= nums[j];
                j++;
            }
               set.add(nums[i]);
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }
         return maxSum;
    }
}