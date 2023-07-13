package leetcode.tree;

public class Leetcode_530 {
    TreeNode pre;
    int result = Integer.MAX_VALUE;

    // �ҵ����������������������ڵ�֮�����С��ֵ
    public int getMinimumDifferenceMethodTwo(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root);
        return result;
    }

    // �ݹ��������������
    private void traversal(TreeNode temp) {
        if (temp == null) {
            return;
        }
        traversal(temp.left);
        if (pre != null) {
            result = Math.min(result, temp.val - pre.val);
        }
        pre = temp;
        traversal(temp.right);
    }
}
