import java.util.Scanner;
public class InsertionSort {
    int[] arr;
    int size;

    InsertionSort(int size){
        this.size = size;
        arr= new int[size];
    }

    public void insertSort(){
        for(int i =1 ; i < size ; i++){
            int current = arr[i];
            int j = i-1;

            while(j>=0 && current < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;

        }
    }
    public void print(){
        for(int i =0 ; i < size ; i++){
            System.out.print(arr[i] + ","+" ");
        }
    }
}
class MainSort {
    public static void main(String[] args) {
        InsertionSort insert = new InsertionSort(6);
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the array :");
        for(int i =0 ; i < insert.size ; i++){
           insert.arr[i] = scanner.nextInt();
        }
        System.out.println();

        //sorting array here
        insert.insertSort();
        System.out.println("The Sorted array are :");

        insert.print();
    }


}
