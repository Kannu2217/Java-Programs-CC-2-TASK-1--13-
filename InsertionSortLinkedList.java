                                                                                                                                                       3
                                                                                                                                                       +        import java.util.Scanner;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class InsertionSortLinkedList {
    public static ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) return newNode;
        ListNode curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
        return head;
    }
    public static ListNode insertionSortList(ListNode head) {
        ListNode sorted = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            sorted = sortedInsert(sorted, current);
            current = next;
        }
        return sorted;
    }
    public static ListNode sortedInsert(ListNode sorted, ListNode newNode) {
        if (sorted == null || sorted.val >= newNode.val) {
            newNode.next = sorted;
            return newNode;
        } else {
            ListNode curr = sorted;
            while (curr.next != null && curr.next.val < newNode.val) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            return sorted;
        }
        public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode head = null;
        System.out.println("Enter integers to sort (type any non-integer to finish):");
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            head = insert(head, num);
        }
        System.out.print("Original List: ");
        printList(head);
        head = insertionSortList(head);
        System.out.print("Sorted List: ");
        printList(head);
    }
}

