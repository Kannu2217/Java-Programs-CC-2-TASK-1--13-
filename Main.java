public class Main {
    static int product(int[] ar, int n) {
        int result = 1;
        for (int i = 0; i < n; i++)
            result = result * ar[i];
        return result;
    }
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};
        int n = ar.length;
        System.out.println(product(ar, n));
    }
}

   