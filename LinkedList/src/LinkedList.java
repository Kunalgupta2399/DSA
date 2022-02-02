public class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    void create(int input) {
        Node node = new Node(input);
        head = node;
        System.out.println("List is created With " + input);
    }

    void insertBeginning(int input) {
        Node node = new Node(input);
        if (head == null) {
            create(input);
            System.out.println(input + "added tp list");
        }

        node.next = head;
        head = node;
        System.out.println("List is created with new node" + input);

    }

    void insertEnd(int input) {
        Node node = new Node(input);

        if (head == null) {
            create(input);
            System.out.println(input + "added to list");
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        System.out.println(input + " added to the list");
    }

    void insertBefore(int value, int input) {
        if (head == null) {
            System.out.println("List is empty");
        }

        Node current = head;
        boolean found = true;
        while (current.next.data != value) {
            current = current.next;
            if (current == null) {
                found = false;
                break;
            }

            if (found) {
                Node node = new Node(input);
                node.next = current.next;
                current.next = node;
                System.out.println(input + " added to the list after " + value);
                return;
            } else {
                System.out.println("Not found");
            }
        }
    }

    void insertAfter(int input, int value) {
        if (head == null) {
            System.out.println("List is empty");
        }

        Node current = head;
        boolean found = true;

        while (current.data != value) {
            current = current.next;
            if (current == null) {
                found = false;
                break;
            }
        }
        if (found) {
            Node node = new Node(input);
            node.next = current.next;
            current.next = node;
            System.out.println(input + " added to the list after " + value);
            return;
        } else {
            System.out.println("value not in the list");
        }
    }

    int removeBeginning() {
        if (head == null) {
            System.out.println("List is underflow");
        }

        Node node = head;
        head = head.next;
        return node.data;
    }

    int removeEnd() {
        if (head == null) {
            System.out.println("List is underflow");
            return -404;
        }
        Node node;
        if (head.next == null) {
            return head.data;
        }
        Node current = head;
        while (current.next.next != null){
            current = current.next;
        }
        node = current.next;
        current.next = null;
        return node.data;
    }

    int removeBefore(int value){
        if (head == null){
            System.out.println("list is empty, underflow");
            return -404;
        }
        if (head.next == null){
            System.out.println("only one element in the list");
            return -404;
        }
        if (head.next.data == value){
            removeBeginning();
        }
        Node current = head;
        boolean found = true;

        while (current.next.next.data != value){
            current = current.next;
            if (current == null){
                found = false;
                break;
            }
        }
        if (found){
            Node node = current.next;
            current.next = node.next;
            node.next = null;
            return node.data;
        }else {
            System.out.println("value not in the list");
            return -404;
        }
    }
    int removeAfter(int value) {
        //check if the list is empty
        if(head == null) {
            System.out.println("list is empty, underflow");
            return -404;
        }

        if(head.next == null) {
            System.out.println("only one element in the list");
            return -404;
        }

        Node current = head;
        boolean found = true;

        while(current.data != value) {
            current = current.next;

            if(current == null) {
                found = false;
                break;
            }
        }

        if(found) {
            Node node = current.next;
            current.next = node.next;
            node.next = null;
            return node.data;
        } else {
            System.out.println("value not in the list");
            return -404;
        }

    }

}
