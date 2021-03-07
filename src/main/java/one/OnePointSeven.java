package one;

public class OnePointSeven {
    public static void main(String[] args) {
        Zero z = new Zero();
        int[][] mat = {
                {1,2,3,4,5,6,0},
                {4,5,0,3,4,1,2},
                {7,8,9,3,4,6,7},
                {7,0,9,3,4,6,7},
                {7,8,9,3,4,6,7},
        };
        z.print(mat, 5, 7);
        int[][] rotated = z.replace(mat, 5,7);
        z.print(rotated, 5,7);
    }
}

class Zero {
    public int[][] replace(int[][] mat, int m, int n) {
        boolean[] col = new boolean[m];
        boolean[] row = new boolean[n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) {
                    col[i] = true;
                    row[j] = true;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(col[i]) {
                    mat[i][j] = 0;
                } else if (row[j]) {
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }

    public void print(int[][] mat, int m, int n) {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(mat[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}

