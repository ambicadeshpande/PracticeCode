
public class LinkedList {
    Node head;
    static class Node {
        Node next;
        int data;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    public void printLinkedList() {
        Node n = head;
        if (head == null) {
            System.out.println("List is empty");
        }
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }

    }

    public void insertAtHead(int new_data) {

        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void insertAfter(Node prev_node, int new_data) {

        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;

    }

    public void insertEnd(int new_data) {

        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
            return;
        }

        // The new node at the end should point to null
        new_node.next = null;

        Node last = head;
        while (last.next != null) {
           //Loop through and get the last element
            last = last.next;
        }
        last.next = new_node;
        return;
    }




    public int findLengthOfLL() {

        int len = 0;
        Node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public int findLengthOfLLRec(Node node) {

        if (node == null) {
            return 0;
        }

        // Count is this node plus rest of the list
        return 1 + findLengthOfLLRec(node.next);
    }

    //Wrapper over findLengthOfLLRec
    public int getLen() {
        return findLengthOfLLRec(head);
    }


    public void DeleteNode(int delete_data){

        Node temp = head;
        Node prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == delete_data) {
            head = temp.next;
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != delete_data) {
            //Get the previous node of the node you want to delete
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) {
            return;
        }
        prev.next = temp.next;
    }

    public void DeleteNodeAtPosition(int pos) {
        //Store head node
        Node temp = head;

        if (temp == null) {
            return;
        }

        //Delete the element at position 0 which is head node
        if (pos == 0) {
            head = temp.next;
            return;
        }

        for (int i = 0; temp != null && i < pos-1; i++) {
            temp = temp.next;
            if (temp == null || temp.next == null)
                return;
            Node next = temp.next.next;
            temp.next = next;
        }
    }

    // Function deletes the entire linked list
    public void deleteList() {
        head = null;
    }




    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        ll.head.next = second;
        second.next = third;

        //Print all elements of Linked list
        ll.printLinkedList();

        //Insert a new node at the start of the Linked List
        ll.insertAtHead(0);
        ll.printLinkedList();

        //Insert a new node after a given node
        ll.insertAfter(second, 5);
        ll.printLinkedList();

        //Find the length of Linked List
        int len = ll.findLengthOfLL();
        System.out.println("Length is: " + len);

        //Insert a new node at the end of the Linked List
        ll.insertEnd(7);
        ll.printLinkedList();

        //Recursively find the length
        int lenRec = ll.getLen();
        System.out.println("Length using recursion is: " + lenRec);



        
        //Delete a node if the key is given
        ll.DeleteNode(3);
        ll.printLinkedList();

        //Delete a node if the position is given
        ll.DeleteNodeAtPosition(4);
        ll.printLinkedList();

        //Delete Linked list
        ll.deleteList();
        ll.printLinkedList();
    }

}
