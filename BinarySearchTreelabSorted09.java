public class BinarySearchTreelabSorted09 {
   static  class SortedTree{
       SortedTree right , left;
       int data;

       SortedTree(int data){
           this.data = data;
           right = left = null;
       }
       public  static SortedTree insert(SortedTree root , int val){
          if(root == null){
              root = new SortedTree(val);
              return  root;
          }
           if(root.data > val){
               root.left=insert(root.left , val);
           }
           else{
              root.right = insert(root.right , val);
           }
           return root;
       }
       public static void Inorder(SortedTree root){
           if(root == null){
               return;
           }

           Inorder(root.left);
           System.out.print(root.data+ " ");
           Inorder(root.right);
       }


       public static void main(String[] args) {

           int[] value = {1,2,3,4,5,6,7,8};
           SortedTree root = null;

           for(int i =0 ; i < value.length ; i++){
               root = (insert( root, value[i]));
           }

           System.out.println("converted to binary search tree Inorder way");
           Inorder(root);


       }
   }

















}
