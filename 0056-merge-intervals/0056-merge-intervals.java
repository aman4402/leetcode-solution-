import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals based on starting value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        // Step 2: Add the first interval
        result.add(intervals[0]);

        // Step 3: Check remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] current = result.get(result.size() - 1);
            int[] next = intervals[i];

            // If intervals overlap
            if (next[0] <= current[1]) {

                // Merge them
                current[1] = Math.max(current[1], next[1]);

            } else {

                // No overlap
                result.add(next);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}