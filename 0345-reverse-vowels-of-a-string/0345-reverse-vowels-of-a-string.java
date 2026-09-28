class Solution {
    public String reverseVowels(String s) {
     char[] arr=s.toCharArray();
     int left=0;
     int right=arr.length-1;
     while(left<right){
        while(left<right&&!isVowel(arr[left]))
        {
        left++;
     }
     while(left<right&&!isVowel(arr[right])){
        right--;

     }
     char temp=arr[left];
     arr[left]=arr[right];
     arr[right]=temp;
     left++;
     right--;
    }
    return new String(arr);
}
public boolean isVowel(char ch){
    return ch=='o'||ch=='e'||ch=='a'||
    ch=='i'||ch=='u'||ch=='A'||ch=='E'||
    ch=='I'||ch=='O'||ch=='U';
}
}