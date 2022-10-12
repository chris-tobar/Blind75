package Easy;

/*
 * Given the roots of two binary trees p and q, write a function 
 * to check if they are the same or not.

    Two binary trees are considered the same if they are 
    structurally identical, and the nodes have the same value.
 */
class problem100{
    
    public static void main(String[] args) {
        
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        
        //Base cases to check
        if(p == null && q!=null)
            return false;
        else if(p != null && q==null)
            return false;
        //Both nodes have reached a leaf node, thus making them the same
        else if(p==null && q==null)
            return true;
        //Both nodes have a child, but they are not the same, so early return
        else if(p.val != q.val)
            return false;
        
        //Both the left and right side need to be true, in order for the WHOLE Tree to be true
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
