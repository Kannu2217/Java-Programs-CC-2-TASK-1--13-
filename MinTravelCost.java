import java.util.*;
public class MinTravelCost {
    public static int minCostTickets(int[] days, int[] costs) {
        boolean[] travel = new boolean[366];
        for (int d : days) travel[d] = true;
        int[] dp = new int[366];
        for (int i = 1; i <= 365; i++) {
            if (!travel[i]) {
                dp[i] = dp[i - 1]; 
            } else {
                dp[i] = Math.min(
                    dp[i - 1] + costs[0], // 1-day ticket
                    Math.min(
                        dp[Math.max(0, i - 7)] + costs[1], 
                        dp[Math.max(0, i - 30)] + costs[2]  
                    )
                );
            }
        }
        return dp[days[days.length - 1]];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of travel days: ");
        int n = sc.nextInt();
        int[] days = new int[n];
        System.out.println("Enter travel days (1–365):");
        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }
        int[] costs = new int[3];
        System.out.println("Enter costs for 1-day, 7-day, and 30-day passes:");
        for (int i = 0; i < 3; i++) {
            costs[i] = sc.nextInt();
        }
        int result = minCostTickets(days, costs);
        System.out.println("Minimum Cost of Travel: " + result);
    }
}
