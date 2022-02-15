package leetcode.editor.cn;

/**
 * @author zhangyanglei <zhangyanglei@kuaishou.com>
 * Created on 2022-01-27
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
