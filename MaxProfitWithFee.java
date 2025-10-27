import java.util.*;
public class MaxProfitWithFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();               
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();
        int fee = sc.nextInt();               
        int hold = -prices[0];
        int cash = 0;
        for (int i = 1; i < n; i++) {
            hold = Math.max(hold, cash - prices[i]);
            cash = Math.max(cash, hold + prices[i] - fee);
        }
        System.out.println(cash); 
    }
}
