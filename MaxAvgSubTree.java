/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class MaxAvgSubTree {
    
    double maxAvg = 0.0;
    
    public double maximumAverageSubtree(TreeNode root) {
        
        maximumAverageSubTree(root);
        
        return maxAvg;
    }
    
    private double[] maximumAverageSubTree(TreeNode root)
    {
        if (root == null)
        {
            return new double[]{0.0, 0.0};
        }
        
        double left[] = maximumAverageSubTree(root.left);
        double right[] = maximumAverageSubTree(root.right);
        
        double sum = left[0] + right[0] + root.val;
        double count = left[1] + right[1] + 1;
        
        maxAvg = Math.max(maxAvg, sum / count);
        
        return new double[]{sum, count};
    }
}
    
    
