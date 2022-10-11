package Medium;

import java.util.Queue;
import java.util.LinkedList;

class problem235{

    public static void main(String[] args) {
        
        System.out.println("Hello world!");
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode left = root;
        TreeNode right = root;
        TreeNode sol = root;
        
        Queue<TreeNode> leftParents = new LinkedList<>();
        Queue<TreeNode> rightParents = new LinkedList<>();
        
        while(left.val != p.val && right.val != q.val)
        {
            leftParents.add(left);
            rightParents.add(right);
            
            
            //Left node w/ p
            if(left.val > p.val)
            {
                left = left.left;
            }
            else if(left.val < p.val)
            {
                left = left.right;
            }
            
            //Right node w/ q
            if(right.val > q.val)
            {
                right = right.left;
            }
            else if(right.val < q.val)
            {
                right = right.right;
            }
            
        }
        
        while(leftParents.peek() != rightParents.peek())
        {
            sol = leftParents.poll();
            rightParents.poll();
        }
        
        
        return sol;
    }
}