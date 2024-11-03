import java.util.*;

public class MergeSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        divide(arr, 0, arr.length - 1);

        System.out.println("Array after sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void divide(int arr[], int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            divide(arr, low, mid);
            divide(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(int arr[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int temp[] = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (int q = 0; q < temp.length; q++) {
            arr[low + q] = temp[q];
        }
    }
}
