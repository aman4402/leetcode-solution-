class Solution {
    public int shipWithinDays(int[] weights, int D) {

        int minCap = 0;
        int maxCap = 0;

        // Find search range
        for (int weight : weights) {
            minCap = Math.max(minCap, weight);
            maxCap += weight;
        }

        // Binary Search
        while (minCap < maxCap) {

            int mid = minCap + (maxCap - minCap) / 2;

            int days = 1;
            int sum = 0;

            // Check how many days are needed
            // if ship capacity is mid
            for (int weight : weights) {

                if (sum + weight > mid) {
                    days++;
                    sum = 0;
                }

                sum += weight;
            }

            if (days > D) {
                // Capacity is too small
                minCap = mid + 1;
            } else {
                // Capacity works, try smaller
                maxCap = mid;
            }
        }

        return minCap;
    }
}