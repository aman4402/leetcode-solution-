import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);

        }
        int ans[]=new int[Math.min(nums1.length,nums2.length)];
        int index=0;
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])&&map.get(nums2[i])>0){
                ans[index]=nums2[i];
                index++;
            
            map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        return Arrays.copyOf(ans,index);
    }
}