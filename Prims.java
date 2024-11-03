import java.util.*;

public class Prims {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int n = sc.nextInt();
        int[][] t = new int[n][2];
        int cost[][] = new int[n][n];
        System.out.println("Enter the cost matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
                if (cost[i][j] == 0 && i != j) {
                    cost[i][j] = INF;
                }
            }
        }
        int minCost = prims(t, cost, n);
        System.out.println("Total cost of MCSPT:" + minCost);
        System.out.println("Edges in the MCSPT:");
        for (int i = 0; i < n - 1; i++) {
            System.out.println((t[i][0] + 1) + "-" + (t[i][1] + 1));
        }
    }

    public static int prims(int[][] t, int[][] cost, int n) {
        int[] near = new int[n];
        int tcost = 0;
        int minCost = INF;
        int k = -1, l = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cost[i][j] < minCost && i != j && cost[i][j] != 0) {
                    minCost = cost[i][j];
                    k = i;
                    l = j;
                }
            }
        }
        t[0][0] = k;
        t[0][1] = l;
        tcost += minCost;
        for (int i = 0; i < n; i++) {
            if (cost[i][k] < cost[i][l]) {
                near[i] = k;
            } else {
                near[i] = l;
            }
        }
        near[k] = near[l] = -1;
        for (int i = 1; i < n - 1; i++) {
            int mCost = INF;
            int min = -1;
            for (int j = 0; j < n; j++) {
                if (near[j] != -1 && cost[j][near[j]] < mCost) {
                    mCost = cost[j][near[j]];
                    min = j;
                }
            }
            t[i][0] = min;
            t[i][1] = near[min];
            tcost += mCost;
            near[min] = -1;
            for (int j = 0; j < n; j++) {
                if (near[j] != -1 && cost[j][min] < cost[j][near[j]]) {
                    near[j] = min;
                }
            }
        }
        return tcost;
    }
}