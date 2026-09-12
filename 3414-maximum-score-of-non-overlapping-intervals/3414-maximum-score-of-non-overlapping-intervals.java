import java.util.*;

class Solution {

    class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    class Result {
        long weight;
        List<Integer> indices;

        Result(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    Interval[] arr;
    int[] next;
    Result[][] dp;
    boolean[][] vis;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();
        arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by starting point
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l)
                return Integer.compare(a.l, b.l);
            return Integer.compare(a.r, b.r);
        });

        // Find next compatible interval
        next = new int[n];

        int[] starts = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = arr[i].l;
        }

        for (int i = 0; i < n; i++) {
            next[i] = upperBound(starts, arr[i].r);
        }

        dp = new Result[n + 1][5];
        vis = new boolean[n + 1][5];

        Result ans = solve(0, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        return result;
    }

    // First position where starts[pos] > target
    private int upperBound(int[] starts, int target) {

        int lo = 0;
        int hi = starts.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (starts[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    private Result solve(int i, int k) {

        if (i >= n || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (vis[i][k]) {
            return dp[i][k];
        }

        vis[i][k] = true;

        // Option 1: Don't take current interval
        Result skip = solve(i + 1, k);

        // Option 2: Take current interval
        Result nextResult = solve(next[i], k - 1);

        List<Integer> takeIndices =
            new ArrayList<>(nextResult.indices);

        takeIndices.add(arr[i].idx);

        // Sort indices because tie-breaking requires
        // lexicographically smallest list
        Collections.sort(takeIndices);

        Result take = new Result(
            arr[i].w + nextResult.weight,
            takeIndices
        );

        dp[i][k] = better(take, skip);

        return dp[i][k];
    }

    private Result better(Result a, Result b) {

        // Higher weight is better
        if (a.weight != b.weight) {
            return a.weight > b.weight ? a : b;
        }

        // Same weight -> lexicographically smaller indices
        return compare(a.indices, b.indices) < 0 ? a : b;
    }

    private int compare(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
}