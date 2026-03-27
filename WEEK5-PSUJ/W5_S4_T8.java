class W5_S4_T8 { // TASk 8 - https://leetcode.com/problems/transpose-matrix
    public int[][] transpose(int[][] matrix) {
        int m,n;
        m=matrix.length;
        n=matrix[0].length;
        int[][] result = new int[n][m];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}