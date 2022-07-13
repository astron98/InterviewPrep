/*
48. Rotate Image

hint: 
1. take transpose of the matrix
2. swap columns values vertically (reverse the matrix on a vertical axis.)
 */

 class Solution {
    public void rotate(int[][] matrix) {
        /*
        Algorithm:
        1. transpose
        2. reverse the matrix on a vertical axis.
        */
        int row = matrix.length, col = matrix[0].length;
        //transpose
        for(int i=0;i<row; i++) {
            for(int j=i+1; j<col; j++) {
                //swap
                swap(matrix, i, j, j, i);
            }
        }
        
        //reverse
        for(int i=0; i<row; i++) {
            for(int j=0; j<col/2;j++) {
                //swap
                swap(matrix, i, j, i, col-j-1);
            }
        }
    }
    
    private void swap(int[][] matrix, int i, int j, int i1, int j1) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i1][j1];
        matrix[i1][j1] = temp;
    }
}

