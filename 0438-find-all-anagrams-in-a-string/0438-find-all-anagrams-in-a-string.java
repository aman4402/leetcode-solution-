class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length()) {
            return ans;
        }

        int[] count = new int[26];

        // Add characters of p
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;
        int required = p.length();

        while (right < s.length()) {

            // Add current character
            if (count[s.charAt(right) - 'a'] > 0) {
                required--;
            }

            count[s.charAt(right) - 'a']--;
            right++;

            // Window size becomes greater than p
            if (right - left > p.length()) {

                count[s.charAt(left) - 'a']++;

                if (count[s.charAt(left) - 'a'] > 0) {
                    required++;
                }

                left++;
            }

            // Anagram found
            if (required == 0) {
                ans.add(left);
            }
        }

        return ans;
    }
}