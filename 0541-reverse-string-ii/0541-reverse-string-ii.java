class Solution {
    public String reverseStr(String s, int k) {
        char[] a=s.toCharArray();
        for(int i=0;i<a.length;i+=2*k){
            int left=i;
            int right=Math.min(i+k-1,a.length-1);
            while(left<right){
                char top=a[left];
                a[left++]=a[right];
                a[right--]=top;
            }

        }
        return new String(a);
    }
}