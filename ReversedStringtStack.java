public class ReversedStringtStack {
    String[] arr;
    int size;
    int index = 0;

    ReversedStringtStack(int size ){
        this.size = size;
        arr = new String[size];
    }

    public void push(String element){
        if(isFull()){
            System.out.println("Stack is full");
        }
        arr[index] = element;
        index++;
    }

    public String pop(){
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

class StringReverse{
    public static void main(String[] args) {
        ReversedStringtStack strRev = new ReversedStringtStack(6);

        strRev.push("S");
        strRev.push("t");
        strRev.push("r");
        strRev.push("i");
        strRev.push("n");
        strRev.push("g");

        System.out.println("Original String");
        strRev.display();

        String reversedString = strRev.ReversedElement();

        System.out.println(reversedString);
    }
}