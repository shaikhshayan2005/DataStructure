public class CircularQueue {
    int[] arr;
    int size;
    int rear = -1;
    int front = -1;

    CircularQueue(int size) {
        this.size = size;
        arr = new int[size];

    }

    public boolean isEmpty(){
        return rear == -1 && front == -1 ;
    }

    public boolean isFull(){
        return (rear + 1) % size == front ;
    }

    //add the data in circular
    public void add( int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % size; // increase rear
        arr[rear] = data;  //rear increase and add the element with respect to the rear
    }

    //remove the element form the circular queue
    public int  remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }

        int result = arr[front]; // first element ko first remove
        //remove the single element in the list
        if(rear == front) {   // both are same at 0 index
            rear = front = -1;
        }
        else{
            front  = (front + 1) % size;  //moving front at the next index
        }

        return  result ;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }

        return arr[front]; // returning the first element

    }


    public void display(){
        for( int i =0 ; i < size ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



}

class Main {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);
        cq.add(5);
        System.out.println("Original Queue");
        cq.display();

        System.out.println("Remove 1 element and add 6");
        System.out.println(cq.remove());
        cq.add(6);

        System.out.println("Remove second element and add 7");
        System.out.println(cq.remove());
        cq.add(7);

        System.out.println("List : ");
        while(!cq.isEmpty()){
            System.out.println(cq.peek());
            cq.remove();
        }
    }
}


