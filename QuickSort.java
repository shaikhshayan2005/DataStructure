import java.util.Scanner;

public class QuickSort {

   int size;
   int[] arr;

    QuickSort(int size){
        this.size = size;
        arr = new int[size];
    }
    public  int partition(int [] arr , int low , int high ){
        int pivot = arr[high];
        int i = low -1; // starting from -1 because we have not encountered any element yet less than the pivot

        for(int j = low ; j < high ; j++){
            if(arr[j] < pivot){
                i++;
                //swapping the less element to the original position
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }

    public  void QuickSort(int[] arr , int low , int high){
    if(low < high){
        int pivotIndex = partition(arr , low , high);

        QuickSort(arr , low , pivotIndex-1); // target the lesser elements than the pivot
        QuickSort(arr , pivotIndex + 1  , high); // target the greater element than the pivot
    }

}

    public void print(){
      for(int i =0 ; i < size ; i++){
          System.out.print(arr[i]+" ");
      }
        System.out.println();
      }


}



class Main {


    public static void main(String[] args) {
       QuickSort sort = new QuickSort(6);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array :");
         for(int i = 0 ; i < sort.size ; i++){
             sort.arr[i] = scanner.nextInt(); //taking the array as the input
         }

        System.out.println("original array is :");
         sort.print();


        sort.QuickSort(sort.arr, 0, sort.size - 1);  //size -1 is to take the last index of the element not the total size of array


        System.out.println("Sorted array is ");
        sort.print();

    }
}