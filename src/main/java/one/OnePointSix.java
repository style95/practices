package one;

public class OnePointSix {
    public static void main(String[] args) {
        Matrix m = new Matrix();
        int[][] mat = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        m.print(mat, 3);
        int[][] rotated = m.rotate(mat, 3);
        m.print(rotated, 3);
    }
}

class Matrix {
    public int[][] rotate(int[][] m, int n) {
        int k = 1;
        for(int i=0; i<n/2; i++) {
            for(int j=i; j < n-k; j++) {
                int temp = m[i][j];
                m[i][j] = m[n-k][j];
                m[n-k][j] = m[n-k][n-k];
                m[n-k][n-k] = m[j][n-k];
                m[j][n-k] = temp;
                print(m, 3);
            }
            k++;
        }
        return m;
    }

    public void print(int[][] m, int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(m[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
