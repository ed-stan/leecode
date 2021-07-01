package com;

public class Demo4 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//    public boolean isBalanced(TreeNode root) {
//
//    }

    public static int getAll(TreeNode root, int num){
        num++;
        if(root==null){
            return num;
        }
        num=getAll(root.right,num);
        num=getAll(root.left,num);
        return num;

    }

//3,9,20,null,null,15,7
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val=3;
        root.left=new TreeNode();
        root.left.val=9;
        root.left.left=null;
        root.left.right=null;

        root.right=new TreeNode();
        root.right.val=20;
        root.right.left=new TreeNode();
        root.right.left.val=15;
        root.right.right=new TreeNode();
        root.right.right.val=7;
        root.right.left.left=null;
        root.right.left.right=null;
        root.right.right.left=null;
        root.right.right.right=null;

        int num=0;
        int all = getAll(root, num);
        System.out.println(all);

    }


}
