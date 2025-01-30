
 public class LevelofBinary {
    static class NodesLevel{
         int data;
         NodesLevel right,left;

         NodesLevel(int data){
             this.data = data;
             right = left = null;
         }
     }



    public NodesLevel construct(){

        NodesLevel root = new NodesLevel(30);

        root.left = new NodesLevel(10);
        root.left.left = new NodesLevel(8);
        root.left.right = new NodesLevel(2);

        root.right = new NodesLevel(20);
        root.right.left = new NodesLevel(18);
        root.right.right = new NodesLevel(2);

         return root;
    }

    public static  void inorder(NodesLevel root ){

        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data + " ");
        inorder(root.right);
    }


    public static  void postorder(NodesLevel root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data + " ");
    }

    public static void preorder(NodesLevel root){
        if(root == null){
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }


    public static int findLevel( NodesLevel node , int data , int currentLevel){
        if(node == null){
            return -1;
        }
        if(node.data == data ){
            return  currentLevel;
        }
        int leftLevel = findLevel(node.left , data , currentLevel + 1);
        if(leftLevel != -1){
            return leftLevel;
        }

        return findLevel(node.right , data , currentLevel + 1);
    }

    public static  boolean  completeTree(NodesLevel node , int index , int nodeCount){

        if(node == null){
            return true;
        }
        if(index >= nodeCount){
            return false;
        }
        return  completeTree(node.left , 2 * index + 1 , nodeCount) && completeTree(node.right, 2 * index + 2 , nodeCount);

    }

    public static int Countnode(NodesLevel node){
        if(node == null){
            return 0;
        }
        return 1 + Countnode(node.left) + Countnode(node.right);
    }


    public static boolean CheckChildrenSumProperty(NodesLevel node) {
      if (node == null || node.left==null &&  node.right == null){
          return true;
      }
      int leftSum = 0;
      if(node.left!=null){
          leftSum = node.left.data;
      }

        int rightSum = 0;
        if(node.right!=null){
            rightSum = node.right.data;
        }

        if(node.data == leftSum + rightSum){

            return CheckChildrenSumProperty(node.left)  &&  CheckChildrenSumProperty(node.right);
        }
        else{
            return false;
        }
    }

     public static void main(String[] args) {
        LevelofBinary lb = new LevelofBinary();

         NodesLevel root = lb.construct();
         int data = 7;
         int level = findLevel(root , data , 0);


         if(level!= -1){
             System.out.println(level);
         }
         else {
             System.out.println("Not found");
         }
         int count = Countnode(root);
         System.out.println("Total number of nodes in the tree: " + count);

         // Check if the tree is complete
         boolean isComplete = completeTree(root, 0, count);
         if (isComplete) {
             System.out.println("The tree is complete.");
         } else {
             System.out.println("The tree is not complete.");
         }

         boolean checkProperty =CheckChildrenSumProperty(root);
         if(checkProperty){
             System.out.println("match");
         }
         else{
             System.out.println("Not matched");
         }
    }



 }


