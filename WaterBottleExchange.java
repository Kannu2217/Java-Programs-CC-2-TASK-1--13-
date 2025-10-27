import java.util.*;
public class WaterBottleExchange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numBottles = sc.nextInt();
        int numExchange = sc.nextInt();  
        int drank = 0;
        int empty = 0;
        while (numBottles > 0) {
            drank += numBottles;
            empty += numBottles;
            numBottles = empty / numExchange; 
            empty = empty % numExchange;   
        }
        System.out.println(drank);
    }
}
