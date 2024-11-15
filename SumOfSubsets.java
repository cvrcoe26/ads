import java.util.*;

public class SumOfSubsets {
    private static void findSubsets(int[] arr, int index, List<Integer> currentSubset, int currentSum, int targetSum, List<List<Integer>> result) {
        if (currentSum == targetSum) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        if (index >= arr.length || currentSum > targetSum) {
            return;
        }
        currentSubset.add(arr[index]);
        findSubsets(arr, index + 1, currentSubset, currentSum + arr[index], targetSum, result);
        currentSubset.remove(currentSubset.size() - 1);
        findSubsets(arr, index + 1, currentSubset, currentSum, targetSum, result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the target sum: ");
        int k = sc.nextInt();
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(arr, 0, new ArrayList<>(), 0, k, result);
        System.out.println("Subsets with sum " + k + " are : " + result);
    }
}
