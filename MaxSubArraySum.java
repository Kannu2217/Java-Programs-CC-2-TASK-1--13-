import java.util.*;
public class MaxSubarraySum {
    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for (int num : arr) {
            maxEndingHere += num;
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Maximum Subarray Sum: " + maxSubArraySum(arr));
    }
}
