public class line_test_4 {
    static int[] dr = {0,0,-1,1,1,-1};
    static int[] dc = {1,-1,0,0,-1,1};
    static char[][] map;
    static class Point{
        int row,col;
        Point(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {
        String[] board = {"..XXX..", "X....X.", "..X....", "X.C..X.", ".X.....", "....XX.", "..X.X.."};
        int len = board.length;
        int[][] choices = {{0,0},{0,6}};
        int[][][] rd = new int[len][len][2];
        map = new char[len][len];
        String tmp = null;
        for(int i = 0; i < len; i++){
            tmp = board[i];
            for(int j = 0; j < len; j++){
                map[i][j] = tmp.charAt(j);
            }
        }

        for(int i = 0 ; i < choices.length; i++){

        }


    }
    
}
