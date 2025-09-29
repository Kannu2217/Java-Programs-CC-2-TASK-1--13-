import java.util.*;
public class CheapestFlight {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>())
                 .add(new int[]{flight[1], flight[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        heap.offer(new int[]{0, src, 0});
        int[] minStops = new int[n]; 
        Arrays.fill(minStops, Integer.MAX_VALUE);
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int cost = curr[0], city = curr[1], stops = curr[2];
            if (city == dst) return cost;
            if (stops > K || stops > minStops[city]) continue;
            minStops[city] = stops;
            if (!graph.containsKey(city)) continue;
            for (int[] flight : graph.get(city)) {
                heap.offer(new int[]{cost + flight[1], flight[0], stops + 1});
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 5; 
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {0, 2, 500},
            {2, 3, 100},
            {3, 4, 100}
        };
        int src = 0, dst = 4, K = 2;
        int result = findCheapestPrice(n, flights, src, dst, K);
        System.out.println("Cheapest cost: " + result);
    }
}
