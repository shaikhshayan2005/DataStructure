import java.util.Scanner;
public class BinarySearchTree {

    static class  Node {

        Node right;
        Node left;
        int data;


        Node(int data){
            this.data = data;
        }

        //Node for recursive
        public  static Node insert(Node root , int val){
            if(root == null){  //agr root null hugi to naya Node create kr k root ko Node ki value de dein gy
                root = new Node(val);
                return root;
            }
            if(root.data > val){
                root.left = insert(root.left , val);  // agar root ka data new data say bara ha to left pr subtree bn jai gy
                //sought out hu k jo root ka pointer aye ga left ka wo hmy return huga or store hujai ga root.left ma
            }
            else {
                root.right= insert(root.right , val); //wrna right par subtree bane gy
            }
            return  root;
        }


        public static boolean search(Node root , int key){
            if(root == null){
                return false;
            }
            if(root.data > key){ //search kre ga root k left side par
                return search(root.left , key);
            }
            else if(root.data == key){
                return true;
            }
            else{
                return search(root.right , key);
            }
        }

        public static void inOrder(Node root){

            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data +" ");
            inOrder(root.right);
        }


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the Key :");
            int key = scanner.nextInt();


            int values[] = {5,1,3,4,2,7};
            Node root = null;
            for (int i =0 ; i < values.length ; i++){
                root =insert(root,values[i]);
            }

            inOrder(root);
            System.out.println();

            if(search(root , key)){
                System.out.println("found");
            }
            else {
                System.out.println("Not found");
            }
        }

    }


}
