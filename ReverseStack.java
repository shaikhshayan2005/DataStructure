public class ReverseStack {
  int[] arr;
  int size;
  int index = 0;

  ReverseStack(int size){
      this.size = size;
      arr = new int[size];
  }

  public void push(int element){
      if(isFull()){
          System.out.println("Stack is full");
      }
      arr[index] = element;
      index++;
  }

  public int pop(){
      if(isEmpty()){
          System.out.println("stack is empty");
      }
      return arr[--index];
  }

  public boolean isFull(){
      if(index == size){
          return true;

      }

      return false;
  }
  public boolean isEmpty(){
      if(index == 0){
          return true;
      }
      return false;
  }

  public String  ReversedElement(){
         String  reversedElement = "";

      System.out.println("The Reversed elements are :");

      while(!isEmpty()){
          reversedElement +=pop()+" "; // as the element are popped from the top they are placed as reversed
      }

      return  reversedElement;
  }

  public void display(){
      for(int i =0 ; i < size ; i++){
          System.out.print(arr[i] +" ");
      }
      System.out.println();
  }
}
class Reversed {
    public static void main(String[] args) {
        ReverseStack reverse = new ReverseStack(5);
        reverse.push(10);
        reverse.push(20);
        reverse.push(30);
        reverse.push(40);
        reverse.push(50);
        System.out.println("Original String");
        reverse.display();

       String reversed =  reverse.ReversedElement();
        System.out.println(reversed);

    }
}
