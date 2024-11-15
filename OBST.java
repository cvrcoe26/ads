import java.util.*;
public class OBST {
    public static void bst(double[] p, double[] q, int n) {
        double[][] w = new double[n + 1][n + 1];
        double[][] c = new double[n + 1][n + 1];
        int[][] r = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            w[i][i] = q[i];
            c[i][i] = 0;
            r[i][i] = 0;
        }

        for (int m = 1; m <= n; m++) {
            for (int i = 0; i <= n - m; i++) {
                int j = i + m;
                w[i][j] = w[i][j - 1] + p[j] + q[j];
                double mincost = Double.MAX_VALUE;
                int root = -1;

                for (int k = (i < j - 1 ? r[i][j - 1] : i); k <= (j > i + 1 ? r[i + 1][j] : j); k++) {
                    double cost = (i <= k - 1 ? c[i][k - 1] : 0) + (k <= j ? c[k][j] : 0) + w[i][j];
                    if (cost < mincost) {
                        mincost = cost;
                        root = k;
                    }
                }

                c[i][j] = mincost;
                r[i][j] = root;
            }
        }

        System.out.println("Minimum cost: " + c[0][n]);
        System.out.println("Weight : " + w[0][n]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of keys: ");
        int n = sc.nextInt();

        double[] p = new double[n + 1];
        double[] q = new double[n + 1];

        System.out.println("Enter probabilities for the keys:");
        for (int i = 1; i <= n; i++) {
            System.out.print("p[" + i + "]: ");
            p[i] = sc.nextDouble();
        }

        System.out.println("Enter probabilities for the dummy keys:");
        for (int i = 0; i <= n; i++) {
            System.out.print("q[" + i + "]: ");
            q[i] = sc.nextDouble();
        }

        bst(p, q, n);
    }
}