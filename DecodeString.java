import java.util.Stack;
public class DecodeString {
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current != ']') {
                stack.push(current);
            } else {
                StringBuilder decoded = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    decoded.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder count = new StringBuilder();             
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    count.insert(0, stack.pop());
                }
                int repeatCount = Integer.parseInt(count.toString());
                String repeatedStr = decoded.toString().repeat(repeatCount);
                for (char c : repeatedStr.toCharArray()) {
                    stack.push(c);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String encodedString = "3[b2[ca]]";
        String decodedString = decodeString(encodedString);
        System.out.println("Decoded String: " + decodedString);
    }
}
