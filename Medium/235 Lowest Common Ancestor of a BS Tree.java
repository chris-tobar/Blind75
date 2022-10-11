package Medium;

import java.util.Queue;
import java.util.LinkedList;

class problem235{

    public static void main(String[] args) {
        
        System.out.println("Hello world!");
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //Left node and right node to traverse the trees
        TreeNode left = root;
        TreeNode right = root;
        TreeNode sol = root;
        
        //Queues to keep track of pathway taken to reach nodes
        Queue<TreeNode> leftParents = new LinkedList<>();
        Queue<TreeNode> rightParents = new LinkedList<>();
        
        //Keep looping until we found the values we are searching for
        while(left.val != p.val && right.val != q.val)
        {
            //Add both of them to the queue, since its own node can equal itself
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
        
        //We found the nodes for both, so now we keep looping until we find a node
        //where they don't match up, and we should have found our solution
        //Error in logic somewehre in code, because incorrect node is returned
        while(leftParents.peek() != rightParents.peek())
        {
            sol = leftParents.poll();
            rightParents.poll();
        }
        
        
        return sol;
    }
}