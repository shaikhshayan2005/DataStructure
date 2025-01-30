class Node1 {
    int data;
    Node1 next;
    Node1(int data){
        this.data = data;
        this.next = null;
    }
}

class Minimum{
    Node1 front, rear;
    public void add(int data){
        Node1 newNode = new Node1(data);
        if(front == null){
            front = rear = newNode;

        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int getMinimum(){
        if(front == null){
            System.out.println("Queue is empty");
        }
        int min = front.data;
        Node1 current = front;

        while (current != null){
            if(current.data < min){
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }


    public void display(){
        Node1 current = front;

        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }

        System.out.print("null");
        System.out.println();
    }

    public boolean isEmpty(){
        return  front == null && rear == null;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }
        return front.data;
    }

}
public class GetMinimun {
    public static void main(String[] args) {
        Minimum mini = new Minimum();

        mini.add(12);
        mini.add(35);
        mini.add(45);
        mini.add(32);
        mini.add(2);

        System.out.println("Original list is :");
        mini.display();

        System.out.println("Minimum value form the list is :");
        System.out.println( mini.getMinimum());


    }
}
