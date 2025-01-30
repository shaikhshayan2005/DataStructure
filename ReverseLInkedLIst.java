class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class ReverseK{

        Node front, rear;
        public void add(int data){
            Node newNode = new Node(data);
            if(front == null){
                front = rear = newNode;

            }
            else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        public void reverse(int k){

            Node prev = null;
            Node current = front;
            Node next;
            int count = 0;

            while(current != null && count < k){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;

                count++;
            }

            if(front !=null){
                front.next = current;
            }
             front = prev;
        }


    public boolean isEmpty(){
        return front == null && rear == null;
    }


    public int peek(){
            if (isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }

            return  front.data;
        }

        public void display(){
            Node current = front;

            while(current != null){
                System.out.print(current.data + "->");
               current = current.next;
            }

            System.out.print("null");
        }

}

public class ReverseLInkedLIst {
    public static void main(String[] args) {
        ReverseK k = new ReverseK();
        k.add(1);
        k.add(2);
        k.add(3);
        k.add(4);
        k.add(5);

        k.display();
        k.reverse(3);
        System.out.println();
        k.display();


    }


}
