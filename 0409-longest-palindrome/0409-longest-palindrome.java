class Solution {
    public int longestPalindrome(String s) {
        int[] freq=new int[128];
        int count=0;
        boolean odd=false;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }
        for(int i=0;i<128;i++){
            if(freq[i]%2==0){
                count+=freq[i];
            }else{
                count+=freq[i]-1;
                odd=true;
            }
        }
        if(odd){
            count++;
        }
        return count;
    }
}