package Easy;


class problem104{
    
    public static void main(String[] args) {
        
    }

    
    public static int maxDepth(TreeNode root) {
        
        //Use the helper function, starting a depth of 0
        //if the node we currently traversed is null, then we have a depth of 0
        return DFS(root, 0);
    }
    
    //Helper function that traverses the tree
    public static int DFS(TreeNode root, int depth)
    {
        //Node visiting is null, so we return the current depth that we found
        if(root == null)
            return depth;
        
        //Iterate on the left node
        int left = DFS(root.left, depth+1);
        //Iterate on the right node
        int right = DFS(root.right, depth+1);
        
        //Return the max of the two found
        return Math.max(left,right);
        
    }
}
