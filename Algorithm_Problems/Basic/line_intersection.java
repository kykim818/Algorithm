import java.util.*;


public class line_intersection{
    static class Point{
        int row,col;
        Point(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    static ArrayList<Point> list = new ArrayList<>();
    public static void main(String[] args) {
        // int[][] line = {{2,-1,4},{-2,-1,4},{0,-1,1},{5,-8,-12},{5,8,12}};
        int[][] line = {{0,1,-1},{1,0,-1},{1,0,1}};

        int len = line.length;
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                findPoints(line[i],line[j]);
            }
        }
        int maxRow = Integer.MIN_VALUE;
        int minRow = Integer.MAX_VALUE;

        int maxCol = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++){
            maxRow = Math.max(maxRow, list.get(i).row);
            maxCol = Math.max(maxCol, list.get(i).col);
            minRow = Math.min(minRow, list.get(i).row);
            minCol = Math.min(minCol, list.get(i).col);
            // System.out.println("x :" + list.get(i).col + " y : "+ list.get(i).row);
        }

        // System.out.println(maxRow);
        // System.out.println(maxCol);
        // System.out.println(minRow);
        // System.out.println(minCol);

        char[][] map = new char[maxRow - minRow + 1][maxCol - minCol + 1];
        for(int i = 0; i < map.length; i++){
            Arrays.fill(map[i], '.');
        }

        for(int i = 0; i < list.size(); i++){
            map[Math.abs(list.get(i).row - maxRow)][Math.abs(list.get(i).col - minCol)] = '*';
        }
        String[] answer = new String[map.length];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                sb.append(map[i][j]);
            }
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        
        for(int i = 0; i < map.length; i++){
            System.out.println(answer[i]);
        }

        // int a1 = 1;
        // int a2 = 4;
        // double A =  (double) a1 / a2;
        // System.out.println(A);
        
    }
    // 두선분의 교점 찾기
    private static void findPoints(int[] A,int[] B){
        double row = (double) (A[0] * B[2] - B[0] * A[2]) / (B[0] * A[1] - A[0] * B[1]);  // y
        double col = (double) (A[1] * B[2] -B[1] * A[2]) / (A[0] * B[1] - B[0] * A[1]);// x
        // 둘다 정수면
        if((row - (int)row == 0) && col - (int)col == 0){
            list.add(new Point((int)row,(int)col));
        }
    }
}
