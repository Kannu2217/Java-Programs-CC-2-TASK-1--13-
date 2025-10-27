import java.util.*;
public class DroneDeliveryOptimization {
    static class Route {
        int energy;
        int distance;
        double efficiency;
        Route(int energy, int distance) {
            this.energy = energy;
            this.distance = distance;
            this.efficiency = (double) distance / energy;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of routes (n): ");
        int n = sc.nextInt();
        System.out.print("Enter total battery capacity (B): ");
        int B = sc.nextInt();
        int[] energy = new int[n];
        int[] distance = new int[n];
        System.out.println("Enter energy and distance for each route:");
        for (int i = 0; i < n; i++) {
            energy[i] = sc.nextInt();
            distance[i] = sc.nextInt();
        }
        List<Route> routes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            routes.add(new Route(energy[i], distance[i]));
        }
        routes.sort((a, b) -> Double.compare(b.efficiency, a.efficiency));
        int[] dp = new int[B + 1]; // dp[b] = max deliveries possible with battery b
        for (Route r : routes) {
            for (int b = B; b >= r.energy; b--) {
                dp[b] = Math.max(dp[b], dp[b - r.energy] + 1);
            }
        }
        int maxDeliveries = 0;
        for (int b = 0; b <= B; b++) {
            maxDeliveries = Math.max(maxDeliveries, dp[b]);
        }
        System.out.println("\nMaximum number of deliveries possible: " + maxDeliveries);
    }
}
