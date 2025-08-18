import java.util.*;
public class DiskTower {
    static void arrangeDisks(int[] disks, int day, int expected, Set<Integer> waiting) {
        if (day == disks.length) return;
        waiting.add(disks[day]);
        System.out.print("Day " + (day + 1) + ": ");
        while (waiting.contains(expected)) {
            System.out.print(expected + " ");
            waiting.remove(expected);
            expected--;
        }
        System.out.println();
        arrangeDisks(disks, day + 1, expected, waiting);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();
        int[] disks = new int[n];
        System.out.println("Enter disk sizes in arrival order:");
        for (int i = 0; i < n; i++) {
            disks[i] = sc.nextInt();
        }
        arrangeDisks(disks, 0, n, new TreeSet<>(Collections.reverseOrder()));
        sc.close();
    }
}
