import java.util.Scanner;
public class PasswordValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String pwd = sc.nextLine();
        boolean valid = pwd.length() >= 8 &&
                        pwd.matches(".*[A-Z].*") &&  
                        pwd.matches(".*[a-z].*") &&
                        pwd.matches(".*\\d.*") &&     
                        pwd.matches(".*[@#!$%^&()]+.*"); 
        System.out.println(valid ? "Valid Password" : "Invalid Password");
        sc.close();
    }
}

