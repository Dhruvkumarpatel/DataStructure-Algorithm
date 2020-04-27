class SubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        return s != null && (isEqual(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t));
        
    }
    
    public boolean isEqual(TreeNode s, TreeNode t)
    {
        if (s == null && t == null)
        {
            return true;
        }
        
        if (s != null && t != null)
        {
            return s.val == t.val && isEqual(s.left, t.left) && isEqual(s.right, t.right);
        }
        
        return false;
    }
        
}