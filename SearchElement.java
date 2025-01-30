public class SearchElement {
    int arr[];
    int size;
    int index = 0;

    SearchElement(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("stack is full");
        }
        arr[index] = element;
        index++;

    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        }
        return arr[--index];
    }

    public boolean isEmpty() {
        if (index == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (index == size) {
            return true;

        }
        return false;
    }

    public int size() {
        return index;
    }


    public  int   searching(int element){
        for(int i = index - 1 ; i >= 0 ; i-- ){
            if(arr[i] == element){
                System.out.println("index is :"+(index - i));
                System.out.println("The value is :"+arr[i]);
                return index - i;
            }


        }
        return -1;

    }

    public int  peek(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return -1;
        }
        return arr[index - 1];
    }

    public static void main(String[] args) {
        SearchElement search = new SearchElement(5);
        search.push(10);
        search.push(20);
        search.push(30);
        search.push(40);
        search.push(50);





        System.out.println("Size of stack after push :"+search.size());
        System.out.println("Top element at peek is :"+search.peek());

        int position = search.searching(30);
        if(position != -1){
            System.out.println("element found :"+ position);
        }
        else {
            System.out.println("element not found");
        }



     }
}


