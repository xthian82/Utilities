package py.com.cracking.code.interview;

public class RotateMatrix {

    public static void main(String[] args) {
        int [][] matrix =
                { //     0    1   2   3   4
                  /*0*/ {7,   8,  9,  1,  2},
                  /*1*/ {11, 12, 13, 20, 21},
                  /*2*/ {5,   3,  6,  4, 10},
                  /*3*/ {15, 16, 17, 18, 19},
                  /*4*/ {22, 23, 24, 25, 26}
                };

        RotateMatrix app = new RotateMatrix();
        app.display(matrix);
        app.rotate(matrix);
        app.display(matrix);
    }

    void swap(int [][] m, int r1, int c1, int r2, int c2) {
        //System.out.println("swp ("+r1 + ","+c1+") with (" + r2 + "," + c2 + ")");
        int tmp = m[r1][c1];
        m[r1][c1] = m[r2][c2];
        m[r2][c2] = tmp;
    }
    void rotate(int [][] m) {
        int R = m.length - 1;
        int C = m[0].length - 1;

        for (int row = 0; row < (R + 1) / 2; row++) {
            for (int col = row; col < C - row; col++) {
                // System.out.print("(" + row + ", " + col + ") ");

                swap(m, row, col, col, C - row);
                swap(m, row, col, R - row, C - col);
                swap(m, row, col, R - col, row);
            }

        }
        // 1,1                      => 1, colLength - 1
        // 1, colLength - 1         => filLength-1, colLength-1
        // filLength-1, colLength-1 => filLength-1, 1
        // filLength-1, 1           => 1, 1

        // 0,0 => 0,colLength
        // 0,colLength => filLength,colLength
        // filLength,colLength => filLength,0
        // filLength,0 => 0,0

        // 0,1 => 1,colLength
        // 1,colLength => filLength-0,colLength-1
        // filLength-0,colLength-1 => filLength-1,0
        // filLength-1,0 => 0,1

        // 0,2 => 2,colLength
        // 2,colLength => filLength,colLength-2
        // filLength,colLength-2 => filLength-2,0
        // filLength-2,0 => 0,2
    }

    void display(int [][] m) {
        System.out.println();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%3d", m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}


/*
*     0  1  2  3  4
*    ______________
* 0 | 7  8  9  1  2
* 1 |11 12 13 20 21
* 2 |5   3  6  4 10
* 3 |15 16 17 18 19
* 4 |22 23 24 25 26
* 5 |27 28 29 30 31
*
* */