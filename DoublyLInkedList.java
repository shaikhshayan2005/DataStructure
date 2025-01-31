class Nodes{
    Nodes prev;
    Nodes next;
    int data;


    Nodes(int data){
        this.data = data;
        this.next = null;
    }
}


public class DoublyLInkedList {
    Nodes head, tail;

    public void addAtBegining(int data) {
        Nodes newNode = new Nodes(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        }
    }

    public void insertAtend(int data) {
        Nodes newNode = new Nodes(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAtSpecific(int data, int pos) {
        Nodes newNode = new Nodes(data);

        Nodes current = head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;

    }


    public void deleteAtBegining() {
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteAtSpecific(int pos) {
        int count = 0;
        Nodes current = head;
        while (current != null && count < pos - 1) {
            current = current.next;
            count++;
        }

        if (current == null || current.next == null) {
            System.out.println("invalid position");
        } else {
            current.next = current.next.next;
            current.next.prev = current;
        }

    }

    public void deleteAtEnd() {
        Nodes current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
        tail = current.prev;
    }

    public void printlist() {
        Nodes current = head;

        while (current != null) {
            System.out.print(current.data + " <=> ");
            current = current.next;
        }
        System.out.println("null");

    }
}
 class Double{
    public static void main(String[] args) {
        DoublyLInkedList dl = new DoublyLInkedList();

        dl.addAtBegining(10);
        dl.addAtBegining(20);
        dl.addAtBegining(30);
        dl.addAtBegining(40);

        dl.printlist();


        dl.insertAtSpecific(15,2);
        dl.printlist();


        dl.insertAtend(50);
        dl.printlist();

        dl.deleteAtBegining();
        dl.printlist();



        dl.deleteAtEnd();
        dl.printlist();



        dl.deleteAtSpecific(2);
        dl.printlist();

    }
}
