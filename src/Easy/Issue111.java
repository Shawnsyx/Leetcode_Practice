package Easy;


public class Issue111 {
  public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val){
      this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
    }  
  }

  class Solution{
    public int minDepth(TreeNode root) {
      if(root==null) return 0;
      if(root.right==null && root.left==null) return 1; //叶子节点
      int Max_value = 111111;
      int rightDepth = (root.right==null? Max_value:minDepth(root.right)+1);
      int leftDepth = (root.left==null?Max_value:minDepth(root.left)+1);
      return leftDepth < rightDepth?leftDepth:rightDepth;
    }    
  }
  
  /**
   * Others:
   *  //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
   *  //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度 
   *  //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
   *  //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
   *  class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1,m2) + 1;
    }
}
   */
  
  
}
