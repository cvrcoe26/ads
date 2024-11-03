import java.util.*;

public class Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Objects: ");
        int n = sc.nextInt();
        System.err.println("Enter the total weight of Knapsack:");
        int m = sc.nextInt();
        float[] profits = new float[n];
        float[] weights = new float[n];
        float[] fracs = new float[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the profit and weight of object : " + (i + 1));
            profits[i] = sc.nextFloat();
            weights[i] = sc.nextFloat();
            fracs[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (profits[i] / weights[i] > profits[j] / weights[j]) {
                    float temp = profits[i];
                    profits[i] = profits[j];
                    profits[j] = temp;
                    temp = weights[i];
                    weights[i] = weights[j];
                    weights[j] = temp;
                }
            }
        }
        float rem = m;
        int l = 0;
        for (int i = 0; i < n; i++) {
            if (weights[i] <= rem) {
                rem -= weights[i];
                fracs[i] = 1;
            } else {
                l = i;
                break;
            }
        }
        if (l <= n) {
            fracs[l] = (rem / weights[l]);
        }
        float total = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(fracs[i]);
            total += fracs[i] * profits[i];
        }
        System.out.println("total profit is : " + total);
    }
}