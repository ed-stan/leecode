package leecode;

import java.util.ArrayList;
import java.util.List;

public class Leevode226 {
    public static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(Integer val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public List<TreeNode> datas;

        TreeNode(Integer[] nums) {
            datas = new ArrayList<TreeNode>();
            //        将一个数组的值依次转换为Node节点
            for (Integer o : nums) {
                datas.add(new TreeNode(o));
            }
            //  第一个数为根节点
            val = datas.get(0).val;

            //    建立二叉树
            for (int i = 0; i < nums.length / 2; i++) {
            //  左孩子
                datas.get(i).left = datas.get(i * 2 + 1);
            // 右孩子
                if (i * 2 + 2 < datas.size()) {//避免偶数的时候 下标越界
                    datas.get(i).right = datas.get(i * 2 + 2);
                }
            }
            left=datas.get(0).left;
            right=datas.get(0).right;
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root==null) {
            return root;
        } else {
            TreeNode treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;
            root.left = invertTree(root.left);
            root.right =invertTree(root.right);
        }
        return root;
    }

    public static void print(TreeNode root){
        if (root==null)
            return;
        System.out.println(root.val);
        print(root.left);
        print(root.right);


    }

    public static void main(String[] args) {
        Integer i=null;
        Integer[] treenums={2,3,i,1};

        TreeNode root = new TreeNode(treenums);

        TreeNode treeNode = invertTree(root);
        print(treeNode);

    }
}
