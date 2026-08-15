class Solution {
    public void setZeroes(int[][] matrix) {

        boolean firstRow = false;
        boolean firstCol = false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Check whether first row or first column
        // originally contains a zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == 0) {

                    if (i == 0) {
                        firstRow = true;
                    }

                    if (j == 0) {
                        firstCol = true;
                    }

                    // Use first row and first column as markers
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Step 2: Set inner matrix to zero
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Set first row to zero if needed
        if (firstRow) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Set first column to zero if needed
        if (firstCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}