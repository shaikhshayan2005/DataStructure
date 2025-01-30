import java.sql.PreparedStatement;

class TreeNode{
    TreeNode right , left ;
    String data;
    TreeNode(String data){
        this.data = data;
        left = right = null;

    }
}

public class BinaryTreeLab09 {
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void PostOrder(TreeNode root){
        if(root == null){
            return;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data+ " ");
    }

    public static void  InOrder(TreeNode root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.data+ " ");
        InOrder(root.right);
    }


    public static TreeNode Construct(){

        TreeNode root = new TreeNode("/");

        //left subtree
        root.left= new TreeNode("*");
        root.left.left = new TreeNode("+");
        root.left.right = new TreeNode("-");

        //left child of the left subtree
        root.left.left.left = new TreeNode("5");
        root.left.left.right = new TreeNode("2");

        //right child of the left subtree
        root.left.right.left = new TreeNode("2");
        root.left.right.right = new TreeNode("1");


        //targeting the right side oif the root
        root.right = new TreeNode("+");

        //targeting the right sub child of the right side
        root.right.left = new TreeNode("2");
        //targeting the left child of the right subtree
        root.right.right = new TreeNode("9");

        return root;

    }

    public static void main(String[] args) {
        TreeNode root = Construct();

        System.out.println("Inorder ");
        InOrder(root);
        System.out.print(" ");
        System.out.println();

        System.out.println("Pre Order");
        preOrder(root);
        System.out.println(" ");

        System.out.println("Post Order");
        PostOrder(root);
        System.out.println(" ");

    }






}
