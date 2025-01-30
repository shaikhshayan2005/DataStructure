public class DoubleEndedQeue {
    int[] arr;
    int size;
    int rear = -1;
    int front = -1;

    public boolean isEmpty(){
     return rear == -1 && front == -1;
    }
    public boolean isFull(){
     return (rear + 1) % size == front;
    }

    public void addRear(int data){
     if(isFull()){
         System.out.println("The Queue is full");
         return;
     }
     if(isEmpty()){
         front = 0 ;
     }

     rear = (rear +1) % size;
     arr[rear] = data ;
    }

    public void addFront(int data){
     if(isFull()){
         System.out.println("The Queue is full");
         return;
     }
     if(isEmpty()){
         front = rear = 0;
     }

     front = (front - 1 + size) % size;
     arr[front] = data;

 }
    public int removeFront(){
        if(isEmpty()){
            System.out.println("The Que is empty");
            return -1;
        }
        int result = front;
        if(rear == front){
            rear = front = -1;
        }
        front  = (front +1) % size;
        return result;

    }

    public int removeRear(){
        if(isEmpty()){
            System.out.println("The Deque is empty");
        }
    }











}
