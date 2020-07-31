//Node class in Linked List
class Node {
    int data;
    Node next;
    Node (int d) {
        data = d;
        next = null;
    }
}

public class SearchElementInLL {
    Node head;

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public boolean search(Node head, int search_data) {
        Node current = head;   //Initialize current node
        while(current != null) {
            if(current.data == search_data) {
                return true; //data found
            }
            current = current.next;
        }
        return false;
    }

    public boolean searchRec(Node n, int search_data) {
        //Best case
        if (n == null) {
           return false;
        }
        if (n.data == search_data) {
           return true;
        }
        //Perform recursion for remaining list
        return searchRec(n.next, search_data);
    }

    //Driver function to test above functions
    public static void main(String[] args) {
        SearchElementInLL ll = new SearchElementInLL();
        ll.push(4);
        ll.push(5);
        ll.push(7);
        ll.push(2);
        if (ll.search(ll.head, 2)) {
            System.out.println("Found the element");
        } else {
            System.out.println("Could not find the element");
        }

        if (ll.searchRec(ll.head, 5)) {
            System.out.println("Found the element");
        } else {
            System.out.println("Could not find the element");
        }
    }
}
