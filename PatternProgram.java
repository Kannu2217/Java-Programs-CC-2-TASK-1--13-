import java.util.Scanner;PatternProgram 
public class PatternProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   
        System.out.print("Enter number of rows for pattern: ");
        int rows = sc.nextInt();
        sc.nextLine(); 
        for (int i = 1; i <= rows; i++) {
            System.out.println("*".repeat(i));
        }
        System.out.print("\nEnter main text: ");
        String text = sc.nextLine();
        System.out.print("Enter pattern to search: ");
        String pattern = sc.nextLine();
        int index = text.indexOf(pattern);
        if (index != -1)
            System.out.println("Pattern found at index: " + index);
        else
            System.out.println("Pattern not found.");
        sc.close();
    }
}