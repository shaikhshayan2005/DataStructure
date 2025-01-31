class Node{
    Node next;
    int data;

    Node (int data ){
        this.data = data;
        this.next = null;
    }
}
public class circularLinkedList {

    Node head,tail;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }

        tail.next = head;
    }

    public void insertEnd(int data){
       Node newNode= new Node(data);
        if(head == null){
            head = tail = newNode;
        }

        else {
            tail.next = newNode;
            tail = newNode;
        }

        tail.next = head;

    }

    public void insertAtSpecific(int data , int pos){
        Node newNode = new Node (data);
        if(pos == 1){
            newNode.next = head;
            head = newNode;
        }

        else {
            Node current = head;

            for (int i = 0; i < pos - 1; i++) {

                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        tail.next = head;

    }

    public void deleteBegining(){
        if(head == null){
            System.out.println("NO Node to delete");
        }
        if(head == tail){
            head = tail = null;
        }
        else{
            head = head.next;
            tail.next = head;
        }



    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("No element to delete");
        } else if (head == tail) {  // Only one node in the list
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = head; // Remove tail and link last node to head
            tail = current; // Update tail
        }
    }
    public void deleteAtSpecific(int pos) {
        if (head == null) {
            System.out.println("No element to delete");
            return;
        }

        if (pos == 1) {  // Deleting the first node
            deleteBegining();
            return;
        }

        Node current = head;
        int count = 1;
        while (current != null && count < pos - 1) {
            current = current.next;
            count++;
            if (current == head) {
                System.out.println("Invalid position");
                return;
            }
        }

        if (current == null || current.next == null) {
            System.out.println("Invalid position");
            return;
        }

        current.next = current.next.next;
        if (current.next == head) {
            tail = current; // If we deleted the tail node, update the tail pointer
        }
        tail.next = head; // Maintain circular structure
    }



    public void printlist(){
        if(head == null){
            System.out.println("No elements in the list");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " => ");
            current = current.next;
        } while (current != head);

        System.out.println("Back to Head");
    }

}
class LinkedListCircular{
    public static void main(String[] args) {
        circularLinkedList cl = new circularLinkedList();
        cl.add(5);
        cl.add(10);
        cl.add(15);
        cl.add(20);
        System.out.println("Original");
        cl.printlist();

        cl.insertAtSpecific(16,3);
        cl.printlist();

        System.out.println("After deleting");
        cl.deleteBegining();
        cl.printlist();


        cl.deleteAtSpecific(2);
        System.out.println("Deleting At specific position :");
        cl.printlist();


        cl.deleteEnd();
        System.out.println("deleted ");
        cl.printlist();
    }

}
