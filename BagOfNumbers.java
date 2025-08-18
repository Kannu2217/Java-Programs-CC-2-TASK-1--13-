import java.util.ArrayList;
class BagOfNumbers {
    private ArrayList<Integer> bag = new ArrayList<>();
    public void add(int num) {
        bag.add(num);
    }
    public void remove(int num) {
        bag.remove(Integer.valueOf(num));
    }
    public int size() {
        return bag.size();
    }
    public boolean isEmpty() {
        return bag.isEmpty();
    }
    public void display() {
        System.out.println("Bag elements: " + bag);
    }
    public static void main(String[] args) {
        BagOfNumbers bag = new BagOfNumbers();
        bag.add(10);
        bag.add(20);
        bag.add(10);
        bag.display();
        bag.remove(10);
        bag.display();
        System.out.println("Bag size: " + bag.size());
        System.out.println("Is empty? " + bag.isEmpty());
    }
}
