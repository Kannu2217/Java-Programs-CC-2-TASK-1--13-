class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedList {
    ListNode head;    public void insert(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
    }
    public void remove(int val) {
        if (head == null) return;
        if (head.val == val) {
            head = head.next;
            return;
        }
        ListNode curr = head;
        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }
        if (curr.next != null) {
            curr.next = curr.next.next;
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
        LinkedList ll = new LinkedList();
        ll.insert(2);
        ll.insert(3);
        ll.insert(1);
        ll.insert(7);
        System.out.print("Original List: ");
        ll.printList();
        ll.remove(1); 
        System.out.print("After removing 1: ");
        ll.printList();
    }
}
