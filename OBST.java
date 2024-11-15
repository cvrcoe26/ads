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
        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length;
                w[i][j] = w[i][j - 1] + p[j] + q[j];
                double minCost = Double.MAX_VALUE;
                int root = -1;
                for (int k = i + 1; k <= j; k++) {
                    double cost = (k > i + 1 ? c[i][k - 1] : 0) + (k < j ? c[k][j] : 0) + w[i][j];
                    if (cost < minCost) {
                        minCost = cost;
                        root = k;
                    }
                }
                c[i][j] = minCost;
                r[i][j] = root;
            }
        }
        System.out.println("Minimum cost: " + c[0][n]);
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
