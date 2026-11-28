
class Solution {
    public boolean equalFrequency(String word) {

        int[] freq = new int[26];

        // Step 1: Count frequency
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }

        // Step 2: Try removing each character
        for (int i = 0; i < 26; i++) {

            if (freq[i] == 0) {
                continue;
            }

            freq[i]--;

            int count = 0;

            // Step 3: Check remaining frequencies
            for (int j = 0; j < 26; j++) {

                if (freq[j] > 0) {

                    if (count == 0) {
                        count = freq[j];
                    }
                    else if (count != freq[j]) {
                        count = -1;
                        break;
                    }
                }
            }

            // Step 4: Check result
            if (count != -1) {
                return true;
            }

            freq[i]++;
        }

        return false;
    }
}
