public class BinarySearchTreePractice {
    static class Nodes{
        int data;
        Nodes left ,right;

        Nodes(int data){
            this.data = data;
            left = right = null;
        }

        public static Nodes insert(Nodes root , int val){
           if(root == null){
                root = new Nodes(val);
                return root;
           }

           if(root.data > val){
               root.left = insert(root.left , val);

           }
           else{
               root.right = insert(root.right, val);
           }
           return root;
        }

        public  static void inorder(Nodes root ){
            if(root == null){
                 return;
            }
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);
        }

        public static void preorder(Nodes root){
            if(root == null){
                return;
            }
            System.out.println(root.data +" ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void postOrder( Nodes root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data+" ");
        }

        public static boolean Search(Nodes root , int key){
            if( root == null){
                return false;
            }
            if(root.data > key){
                return Search(root.left , key);
            }
            else if (root.data == key){
                return true;
            }
            else {
            return Search(root.right , key);
            }

        }

        // Method to delete a node with a specific key
        public static Nodes delete(Nodes root, int key) {
            if (root == null) {
                return null; // Key not found
            }

            // Traverse the tree to find the node to delete
            if (key < root.data) {
                root.left = delete(root.left, key);
            } else if (key > root.data) {
                root.right = delete(root.right, key);
            } else {
                // Node found
                // Case 1: Node has no children (leaf node)
                if (root.left == null && root.right == null) {
                    return null;
                }
                // Case 2: Node has one child
                else if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                // Case 3: Node has two children
                else {
                    // Find the in-order successor (smallest node in the right subtree)
                    Nodes successor = findMin(root.right);
                    root.data = successor.data; // Replace root's value with successor's value
                    root.right = delete(root.right, successor.data); // Delete the successor
                }
            }
            return root;
        }

        // Helper method to find the minimum value node in a subtree
        public static Nodes findMin(Nodes root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

        public static void main(String[] args) {
            int[] value = {5,1,3,4,2,7};
            Nodes root = null;
            for(int i =0 ; i < value.length ; i++){
                root = insert(root , value[i]);
            }
            System.out.println("inOrder");
            inorder(root);
            System.out.println();
            System.out.println("preOrder");
            preorder(root);
            System.out.println();
            System.out.println("post order");
            postOrder(root);
            System.out.println();

            if(Search(root , 4)){
                System.out.println("Found");
            }
            else {
                System.out.println("Not found");
            }
        }
    }







}
