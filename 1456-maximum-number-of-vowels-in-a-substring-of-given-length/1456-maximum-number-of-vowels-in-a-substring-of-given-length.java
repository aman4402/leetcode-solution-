class Solution {
    public int maxVowels(String s, int k) {

        int windowVowels = 0;
        int maxVowels = 0;

        // First window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                windowVowels++;
            }
        }

        maxVowels = windowVowels;

        // Sliding window
        for (int i = k; i < s.length(); i++) {

            if (isVowel(s.charAt(i - k))) {
                windowVowels--;
            }

            if (isVowel(s.charAt(i))) {
                windowVowels++;
            }

            maxVowels = Math.max(maxVowels, windowVowels);
        }

        return maxVowels;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}