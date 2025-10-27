import java.util.*;
class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num); // Insert element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(sol.findKthLargest(nums, k)); 
    }
}
