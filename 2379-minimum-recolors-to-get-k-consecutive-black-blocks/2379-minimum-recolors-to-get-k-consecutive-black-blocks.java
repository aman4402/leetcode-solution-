class Solution {
    public int minimumRecolors(String blocks, int k) {

        int count = 0;

        // Count white blocks in the first window
        for(int i = 0; i < k; i++) {
            if(blocks.charAt(i) == 'W') {
                count++;
            }
        }

        int minCount = count;

        // Slide the window
        for(int i = k; i < blocks.length(); i++) {

            // Remove the outgoing character
            if(blocks.charAt(i-k) == 'W') {
                count--;
            }

            // Add the incoming character
            if(blocks.charAt(i) == 'W') {
                count++;
            }

            minCount = Math.min(minCount, count);
        }

        return minCount;
    }
}