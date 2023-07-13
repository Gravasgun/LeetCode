package leetcode.tree;

public class Leetcode_98 {
    public boolean isValidBST(TreeNode root) {
        // ��ʼ���ã������޶�Ϊnull
        return isValidBST(root, null, null);
    }

    // �ݹ麯�����ж���tempΪ���ڵ�Ķ������Ƿ�Ϊһ�úϷ���BST��lower��upper��ʾ������
    private boolean isValidBST(TreeNode temp, Integer lower, Integer upper) {
        if (temp == null) {
            return true;
        }
        if (lower != null && temp.val <= lower) {
            return false;
        }
        if (upper != null && temp.val >= upper) {
            return false;
        }
        return isValidBST(temp.left, lower, temp.val) && isValidBST(temp.right, temp.val, upper);
    }
}
