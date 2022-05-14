//73. Set Matrix Zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 =0, rows = matrix.length, cols = matrix[0].length;
        
        //set the 1st element in that row, col to 0 if we found any element in that respective row/col as 0
        for(int i=0; i<rows; i++) {
            if(matrix[i][0]==0) col0 = 1;
            for(int j=1; j<cols; j++) {
                if(matrix[i][j]==0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }
        
        //now set each rows & cols where its 1st element of that's row/col is 0
        for(int i=rows-1;i>=0; i--) {
            for(int j=cols-1; j>0; j--) {
                if(matrix[0][j]==0 || matrix[i][0]==0)
                    matrix[i][j] = 0;
            }
            
            if(col0==1) matrix[i][0] = 0;
        }
    }
}