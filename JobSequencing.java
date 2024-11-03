import java.util.Scanner;

public class JobSequencing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of jobs: ");
        int n = sc.nextInt();
        int[] d = new int[n + 1];
        int[] profits = new int[n + 1];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the profits and deadlines of Job: " + (i + 1));
            profits[i + 1] = sc.nextInt();
            d[i + 1] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (profits[j] < profits[j + 1]) {
                    int temp = d[j];
                    d[j] = d[j + 1];
                    d[j + 1] = temp;
                    temp = profits[j];
                    profits[j] = profits[j + 1];
                    profits[j + 1] = temp;
                }
            }
        }
        int[] j = new int[n + 1];
        j[0] = 0;
        d[0] = 0;
        j[1] = 1;
        int k = 1;
        for (int i = 2; i < n + 1; i++) {
            int r = k;
            while ((d[j[r]] > d[i]) && d[j[r]] != r) {
                r--;
            }
            if ((d[j[r]] <= d[i]) && d[i] > r) {
                for (int x = k; x >= r + 1; x--) {
                    j[x + 1] = j[x];
                }
                j[r + 1] = i;
                k++;
            }
        }
        int profit = 0;
        System.out.println("Final Job Sequence: ");
        for (int i = 1; i < n + 1; i++) {
            System.out.println(j[i] + " ");
            profit += profits[j[i]];
        }
        System.out.println(profit);
    }
}