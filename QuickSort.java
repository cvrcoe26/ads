import java.util.*;

class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Quick(a, 0, a.length - 1);
        System.out.println("After Sorting:");
        for (int num : a) {
            System.out.print(num + " ");
        }
    }

    static void Quick(int[] a, int l, int h) {
        if (l < h) {
            int j = partition(a, l, h);
            Quick(a, l, j - 1);
            Quick(a, j + 1, h);
        }
    }

    static int partition(int[] a, int l, int h) {
        int pivot = a[l];
        int i = l;
        int j = h + 1;
        do {
            do {
                i++;
            } while (i <= h && a[i] < pivot);

            do {
                j--;
            } while (a[j] > pivot);

            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        } while (i < j);
        a[l] = a[j];
        a[j] = pivot;

        return j;
    }
}
