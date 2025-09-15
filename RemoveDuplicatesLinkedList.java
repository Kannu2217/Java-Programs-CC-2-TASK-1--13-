import java.util.HashSet;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; this.next = null; }
}
public class RemoveDuplicatesLinkedList {
    ListNode head;
    public void insert(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
    }
    public void removeDuplicates() {
        HashSet<Integer> set = new HashSet<>();
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                set.add(curr.val);
                prev = curr;
            }
            curr = curr.next;
        }
    }
    public void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        RemoveDuplicatesLinkedList ll = new RemoveDuplicatesLinkedList();
        ll.insert(12);
        ll.insert(11);
        ll.insert(12);
        ll.insert(21);
        ll.insert(41);
        ll.insert(43);
        ll.insert(21);
        System.out.print("Original List: ");
        ll.printList();
        ll.removeDuplicates();
        System.out.print("After removing duplicates: ");
        ll.printList();
    }
}
