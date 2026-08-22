class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
            // Store nums1 elements
        for (int num : nums1) {
            set.add(num);
        }
        ArrayList<Integer> result=new ArrayList<>();
           // Check nums2 elements
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
                set.remove(num);
            }
        }
           // Convert ArrayList to int[]
        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}