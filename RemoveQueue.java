public class RemoveQueue {
    int[] arr;
    int size;
    int rear= -1;

    RemoveQueue(int size) {
        this.size = size;
        arr = new int[size];
    }

    public boolean  isEmpty(){
        return  rear ==-1;
    }

    public void add( int data){
      if(rear == size -1){
          System.out.println("The Queue is full");
          return;
      }
      rear++;
      arr[rear] =data;

    }

    public int  remove(){
        if(isEmpty()){
            System.out.println("Queue is empty nothing to delete");
          return -1;
        }
        int front = arr[0];
        for(int i = 0 ; i < rear ; i++ ){
            arr[i] = arr[i+1];
        }
        rear--;
        return front;

    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty nothing to delete");
            return -1;
        }

        return arr[0];

    }

    public void reverse(){
        int front = 0;
        int rear = size -1;

        while(front < rear){
            int temp = arr[front];
            arr[front] = arr[rear];
            arr[rear] = temp;

          rear--;
          front++;
        }

    }

    public void display(){
        for(int i =0 ; i < size ; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }



}
class Reverse{
    public static void main(String[] args) {
        RemoveQueue remQueue = new RemoveQueue(4);

        remQueue.add(1);
        remQueue.add(2);
        remQueue.add(3);
        remQueue.add(4);

        System.out.println("The Original array");
        remQueue.display();


        System.out.println("Array Queue after reverse:");
        remQueue.reverse();


        remQueue.display();






    }
}