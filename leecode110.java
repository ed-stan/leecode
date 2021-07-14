package one;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 */

public class leecode110 {
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

//    public static boolean isBalanced(TreeNode root) {
//      if (root==null){
//          return true;
//      }
//      return Dvalue(root)<=1;
//    }

    public static int Dvalue(TreeNode root){
      if (root.left!=null&&root.right!=null){
          return Math.max(Dvalue(root.left),Dvalue(root.right));
      }else {
          if (root.left==null){
              return 1+maxDeep(root.right);
          }else if(root.right==null){
              return 1+maxDeep(root.left);
          }else {
              return 0;
          }
      }
    }

    public static int maxDeep(TreeNode root){
      if (root==null){
          return 0;
      }
      return 1+Math.max(maxDeep(root.left),maxDeep(root.right));
    }

//    =============================

    public static boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private static int height(TreeNode root) {
        if(root == null)
            return 0;
        int lh = height(root.left), rh = height(root.right);
        if(lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
            return Math.max(lh, rh) + 1;
        } else {
            return -1;
        }
    }
//  =======================================================

//    public static int minDeep(TreeNode root){
//        if (root==null){
//            return 0;
//        }
//        return 1+Math.min(minDeep(root.left),minDeep(root.right));
//    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(2);
        node.left.left=new TreeNode(3);
        node.left.left.left=new TreeNode(4);

        node.right.right=new TreeNode(3);
        node.right.right.right=new TreeNode(4);

        int dvalue = Dvalue(node);
        System.out.println(dvalue);
        boolean balanced = isBalanced(node);
        System.out.println(balanced);
    }

}
