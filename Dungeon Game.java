class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        int sumRow = 0, sumCol = 0;
        
        int[][] temp = new int[dungeon.length][dungeon[0].length];
        
        for(int i = dungeon.length - 1; i >= 0; i--){
            sumCol += dungeon[i][dungeon[0].length - 1];
            if(sumCol < 0 ) temp[i][temp[0].length - 1] = Math.abs(sumCol) + 1;
            else {
                temp[i][temp[0].length - 1] = 1;
                sumCol = 0;
            }
        }
        for(int i = dungeon[0].length - 1; i >= 0; i--){
            sumRow += dungeon[dungeon.length - 1][i];
            if(sumRow < 0) temp[temp.length - 1][i] = Math.abs(sumRow) + 1;
            else{
                temp[temp.length - 1][i] = 1;
                sumRow = 0;
            }
        }
        //System.out.println(sumCol + " " +sumRow);
        for(int i = dungeon.length - 2; i >= 0; i--){
            for(int j = dungeon[0].length - 2; j >= 0; j--){
                if(dungeon[i][j] < 0) temp[i][j] = Math.min(temp[i + 1][j], temp[i][j + 1]) + Math.abs(dungeon[i][j]);
                else temp[i][j] = (Math.min(temp[i + 1][j], temp[i][j + 1]) - dungeon[i][j]) >= 1 ? Math.min(temp[i + 1][j], temp[i][j + 1]) - dungeon[i][j] : 1  ;
            }
        }
        
        return temp[0][0];
    }
}
