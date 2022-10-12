package Easy;


class problem104{
    
    public static void main(String[] args) {
        
    }

    public static int maxDepth(TreeNode root) {
        
        return DFS(root, 0);
    }
    
    public static int DFS(TreeNode root, int depth)
    {
        if(root == null)
            return depth;
        
        int left = DFS(root.left, depth+1);
        int right = DFS(root.right, depth+1);
        
        return Math.max(left,right);
        
    }
}
