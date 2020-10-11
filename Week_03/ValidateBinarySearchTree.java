package com.senble.algorithm.week3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 2叉搜索树
 *
 * @author : Senble
 * @version 1
 * @date : 2020/10/5
 */
public class ValidateBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean isValidBST(TreeNode node) {
        return nodeIsInScope(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean nodeIsInScope(TreeNode node, int low, int upper) {
        if (node == null) return true;

        if (node.val < low || node.val > upper) {
            return false;
        }
        if (!nodeIsInScope(node.left, low, node.val)) {
            return false;
        }
        if (!nodeIsInScope(node.right, node.val, upper)) {
            return false;
        }
        return true;
    }

    private Integer preTraversalNodeValue = null;
    //中序遍历树，递归写法
    private boolean isValidBSTRecursiveTraversal(TreeNode node) {
        //终止条件
        if (null == node) {
            return true;
        }
        boolean leftRightful = isValidBSTRecursiveTraversal(node.left);
        boolean centerRightful = nodeValueRight(node.val);
        boolean rightRightful = isValidBSTRecursiveTraversal(node.right);
        return leftRightful && rightRightful && centerRightful;
    }

    private boolean nodeValueRight(int nodeValue) {
        if (preTraversalNodeValue == null) {
            preTraversalNodeValue = nodeValue;
            return true;
        } else {
            if (nodeValue > preTraversalNodeValue) {
                preTraversalNodeValue = nodeValue;
                return true;
            } else {
                return false;
            }
        }
    }

    //中序遍历树，非递归写法
    private boolean isValidBSTInorderTraversalNotRecursive(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        Integer preTraversalNodeValue = null;
        while (!treeNodeStack.isEmpty() && root != null) {
            while (root != null) {
                treeNodeStack.push(root);
                root = root.left;
            }
            root = treeNodeStack.pop();
            System.out.println(root.val);
            if (null == preTraversalNodeValue) {
                preTraversalNodeValue = root.val;
            } else if (root.val <= preTraversalNodeValue){
                return false;
            }
            root = root.right;
        }
        return true;
    }

    @Test
    public void test() {
        TreeNode root = createTree();
//        System.out.println(isValidBST(root));
//        System.out.println(isValidBSTRecursiveTraversal(root));

//        Assert.assertTrue(isValidBST(root));
//        Assert.assertTrue(isValidBST(null));
        Assert.assertFalse(isValidBSTRecursiveTraversal(root));
//        Assert.assertTrue(isValidBSTRecursiveTraversal(null));

//        Assert.assertTrue(isValidBSTInorderTraversalNotRecursive(root));
//        Assert.assertTrue(isValidBSTInorderTraversalNotRecursive(null));
    }

    private TreeNode createTree() {
//        TreeNode root = new TreeNode(10);
//        TreeNode root1 = new TreeNode(8);
//        root.left = root1;
//        root.right = new TreeNode(12);
//        root1.left = new TreeNode(7);
//        root1.right = new TreeNode(9);

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        TreeNode root2 = new TreeNode(4);
        root.right = root2;
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);

        return root;
    }
}
