class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] temp = new int[grid.length][grid[0].length];
        int sumCol = 0, sumRow = 0;
        for(int i = 0; i < grid.length; i++){
            sumCol += grid[i][0];
            temp[i][0] = sumCol;
        }
        
        for(int i = 0; i < grid[0].length; i++){
            sumRow += grid[0][i];
            temp[0][i] = sumRow;
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                //mp[i -j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                temp[i][j] =  Math.min(temp[i - 1][j], temp[i][j - 1]) + grid[i][j];
            }
        }
        return temp[temp.length - 1][temp[0].length - 1];
    }
}
