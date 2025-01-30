 class NodeTree {
    NodeTree right , left ;
    int data;


    NodeTree(int data){
        this.data = data;
        right = left = null;
    }

 }
 public class BinaryTreeConstruct {
    public static void insert(){
        NodeTree root = new NodeTree(1);

        root.left= new NodeTree(2);
        root.left.left = new NodeTree(4);
        root.left.right = new NodeTree(6);

        root.right = new NodeTree(10);
        root.right.left= new NodeTree(7);
        root.right.right = new NodeTree(11);

    }

    public static void inOrder(NodeTree root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }


}
