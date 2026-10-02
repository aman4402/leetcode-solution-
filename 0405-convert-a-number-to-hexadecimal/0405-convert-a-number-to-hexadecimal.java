class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();

        while (num != 0) {
            int remainder = num & 15;

            if (remainder < 10) {
                ans.append((char)('0' + remainder));
            } else {
                ans.append((char)('a' + remainder - 10));
            }

            num = num >>> 4;
        }

        return ans.reverse().toString();
    }
}