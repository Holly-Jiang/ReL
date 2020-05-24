package cn.ecnu.edu.leetcode.March2020;

import java.util.LinkedList;
import java.util.List;

public class BuildTree {
    public static void main(String[] args) {
        System.out.println();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) {
            return null;
        }
        List<Integer> stack = new LinkedList<>();
        stack.add(preorder[0]);
        boolean visited[] = new boolean[preorder.length];

        while(!stack.isEmpty()){


        }
        return new TreeNode(1);
    }
}
