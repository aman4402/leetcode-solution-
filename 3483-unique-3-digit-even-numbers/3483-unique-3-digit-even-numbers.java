class Solution {
    public int totalNumbers(int[] digits) {

        boolean[][][] used = new boolean[10][10][10];

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {

                    if (i == j || j == k || k == i) {
                        continue;
                    }

                    int a = digits[i];
                    int b = digits[j];
                    int c = digits[k];

                    if (a == 0) {
                        continue;
                    }

                    if (c % 2 != 0) {
                        continue;
                    }

                    used[a][b][c] = true;
                }
            }
        }

        int count = 0;

        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {

                    if (used[a][b][c]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}