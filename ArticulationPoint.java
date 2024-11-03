import java.util.*;

public class ArticulationPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int v = sc.nextInt();
        List<Integer> mat[] = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            mat[i] = new ArrayList<>();
        }
        System.out.println("Enter the number of edges: ");
        int e = sc.nextInt();
        System.out.println("Enter the edges for every Pair of Vertices:");
        for (int i = 0; i < e; i++) {
            int fi = sc.nextInt();
            int si = sc.nextInt();
            mat[fi].add(si);
            mat[si].add(fi);
        }
        sc.close();
        System.out.println("Articulation point of the given graph are:");
        AP(mat, v);
    }

    public static void AP(List<Integer>[] mat, int v) {
        for (int i = 1; i <= v; i++) {
            int cnt = 0;
            List<Integer> vis = new ArrayList<>();
            for (int j = 0; j <= v; j++) {
                vis.add(0);
            }
            for (int j = 1; j <= v; j++) {
                if ((j != i) && (vis.get(j) == 0)) {
                    cnt++;
                    dfs(mat, v, vis, i, j);
                }
            }
            if (cnt > 1) {
                System.out.println(i + " ");
            }
        }
    }

    public static void dfs(List<Integer>[] adj, int v, List<Integer> vis, int check, int point) {
        vis.set(point, 1);
        for (int x : adj[point]) {
            if (x != check && vis.get(x) == 0)
                dfs(adj, v, vis, check, x);
        }
    }
}