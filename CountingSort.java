import java.util.Scanner;
import java.util.Arrays;
public class CountingSort {
    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        int[] count = new int[max + 1];
        for (int num : arr) {
            count[num]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[arr.length];     
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " non-negative integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] < 0) {
                System.out.println("Counting sort only supports non-negative integers. Please restart and enter valid input.");
                scanner.close();
                return;
            }
        }
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));
        countingSort(arr);
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));

        scanner.close();
    }
}
   