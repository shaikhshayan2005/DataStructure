public class QueueArray {
 int[] arr;
 int size;
 int rear = -1;

  QueueArray(int size){
     this.size = size;
     arr = new int[size];

 }

 // check if the queue is empty

    public boolean isEmpty(){
      return rear == -1;
    }

 //add or enqueue the element in the Queue
    public void add( int data){
      if(rear == size-1){
          System.out.println("Queue is full");
          return;
      }
      rear++;
      arr[rear] = data;  //rear increase and add the element with respect to the rear
    }

 // remove or dequeue the element form the queue
    public int  remove(){
      if(isEmpty()){
          System.out.println("Queue is empty");
          return -1;
      }

      int front = arr[0]; // first element ko pehly remove krien gay
      for(int i = 0 ; i < rear ; i++){

          arr[i] = arr[i+1]; //arr[0] = arr[0+1] ~ arr[1]; moving the element to the left side
      }
      rear --; // last element is now rear
      return front ;
    }
     public int peek(){
         if(isEmpty()){
             System.out.println("Queue is empty");
             return -1;
         }

       return arr[0]; // returning the first element

    }

    public void display(){
      for( int i =0 ; i < size ; i++){
          System.out.print(arr[i] + " ");
      }
        System.out.println();
    }

}

class Queue {
    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(5);

        //add the element to the Queue
        queueArray.add(1);
        queueArray.add(2);
        queueArray.add(3);
        queueArray.add(4);
        queueArray.add(5);

        System.out.println("Original array");
        queueArray.display();

        System.out.println("removed array");
        while(!queueArray.isEmpty()){
            System.out.println(queueArray.peek());
            queueArray.remove();
        }

    }
}
