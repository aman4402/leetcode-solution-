
class Solution {
    public int countCharacters(String[] words, String chars) {

        int[] freq = new int[26];

        for (int i = 0; i < chars.length(); i++) {
            freq[chars.charAt(i) - 'a']++;
        }

        int result = 0;

        
        for (int i = 0; i < words.length; i++) {

            int[] temp = freq.clone();
            boolean good = true;

            for (int j = 0; j < words[i].length(); j++) {

                char ch = words[i].charAt(j);

                if (temp[ch - 'a'] > 0) {
                    temp[ch - 'a']--;
                } 
                else {
                    good = false;
                    break;
                }
            }

            if (good) {
                result += words[i].length();
            }
        }

        return result;
    }
}
