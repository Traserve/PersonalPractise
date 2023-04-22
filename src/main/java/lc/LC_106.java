package lc;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Martin
 * @date 2022/2/15 23:12
 */

public class LC_106 {

    public static void main(String[] args) {
        buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
//        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        List<Integer> inorderList = new ArrayList<>();
        for (int i : inorder) {
            inorderList.add(i);
        }
        List<Integer> postorderList = new ArrayList<>();
        for (int i : postorder) {
            postorderList.add(i);
        }
        return build(inorderList, postorderList);
    }

    public static TreeNode build(List<Integer> inorderList, List<Integer> postorderList) {
        if (postorderList.isEmpty()) {
            return null;
        }
        int rootVal = postorderList.get(postorderList.size() - 1);
        TreeNode root = new TreeNode(rootVal);
        int leftTreeNodesCount = 0;
        for (Integer i : inorderList) {
            if (i == rootVal) {
                break;
            }
            leftTreeNodesCount++;
        }
        root.left = build(inorderList.subList(0, leftTreeNodesCount), postorderList.subList(0, leftTreeNodesCount));
        root.right = build(inorderList.subList(leftTreeNodesCount + 1, inorderList.size()), postorderList.subList(leftTreeNodesCount, inorderList.size() - 1));
        return root;
    }

}
