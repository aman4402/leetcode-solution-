class Solution {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char o = s.charAt(i);
            char r = t.charAt(i);

            if (!map.containsKey(o)) {

                if (!set.contains(r)) {
                    map.put(o, r);
                    set.add(r);
                } else {
                    return false;
                }

            } else {

                char mappedChar = map.get(o);

                if (mappedChar != r) {
                    return false;
                }
            }
        }

        return true;
    }
}