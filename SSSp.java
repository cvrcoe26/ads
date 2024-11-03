import java.util.*;

public class SSSp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of adjacency matrix");
        int n = sc.nextInt();
        int[][] cost = new int[n + 1][n + 1];
        System.out.println("Enter the Adjacency Matrix");
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        dist[1] = 0;
        for (int l = 0; l < n; l++) {
            int min = -1;
            int minVal = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && dist[i] < minVal) {
                    minVal = dist[i];
                    min = i;
                }
            }
            visited[min] = true;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && cost[min][j] != 0) {
                    if (dist[min] != Integer.MAX_VALUE && dist[j] > dist[min] + cost[min][j]) {
                        dist[j] = dist[min] + cost[min][j];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Node" + (i) + "is Unreachable");
            } else {
                System.out.println("Shortest distance from node ’1’ to node ’" + i + "’ is : " + dist[i]);
            }
        }
    }
}