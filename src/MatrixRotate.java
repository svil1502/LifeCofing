public class MatrixRotate {
    public static void main(String[] args) {
        int[][] a_ = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[][] b = solution(a_);
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.println("k " + b[i][j]);
            }
        }
    }
    static int[][] solution(int[][] a) {
        int [][] rotate = new int[a.length][a.length];
        for(int i = 0; i< a.length; i++) {
            for(int j=0; j<a[i].length; j++){
                rotate[i][j] = a[a.length - j - 1][i];
            }
        }
        return rotate;
    }

}
