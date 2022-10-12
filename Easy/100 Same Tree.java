package Easy;

class problem100{
    
    public static void main(String[] args) {
        
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null && q!=null)
            return false;
        else if(p != null && q==null)
            return false;
        else if(p==null && q==null)
            return true;
        else if(p.val != q.val)
            return false;
        
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
