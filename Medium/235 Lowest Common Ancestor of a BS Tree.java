package Medium;

class problem235{

    public static void main(String[] args) {
        
        System.out.println("Hello world!");
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //
        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);
        
        //Keep iterating until we found our solution, or the nodes doesn't exist
        while (root != null) {

            //Both nodes exist in the left subtree
            if (root.val > large)
                root = root.left;
            //Both nodes exist in the right subtree
            else if (root.val < small)
                root = root.right;
            //Current node is between the two values found
            else
                return root;
        }
        return null;
    }
}