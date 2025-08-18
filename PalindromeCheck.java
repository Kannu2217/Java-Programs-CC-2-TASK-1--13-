import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string/number: ");
        String input = sc.nextLine();
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println(input.equalsIgnoreCase(reversed) ? "Palindrome" : "Not Palindrome");
        sc.close();
    }
}