class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        int i = 0;

        while (i < nums.length) {

            int start = nums[i];

            // Find the end of the consecutive range
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            // If only one number
            if (start == nums[i]) {
                ans.add(String.valueOf(start));
            } 
            // If there is a range
            else {
                ans.add(start + "->" + nums[i]);
            }

            i++;
        }

        return ans;
    }
}