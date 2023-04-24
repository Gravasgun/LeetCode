package leetcode.tree;

public class Leetcode_404 {
    /**
     * 404.��Ҷ��֮��
     * �����������ĸ��ڵ�root������������Ҷ��֮�͡�
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        // �����ǰ�ڵ�Ϊ�գ��򷵻�0
        if (root == null) {
            return 0;
        }
        // �ݹ������������������Ҷ�ӽڵ�ĺͣ��洢��leftSum������
        int leftSum = sumOfLeftLeaves(root.left);
        // �ݹ������������������Ҷ�ӽڵ�ĺͣ��洢��rightSum������
        int rightSum = sumOfLeftLeaves(root.right);
        // ����һ������midValue��ʾ��ǰ�ڵ��ֵ��Ĭ��Ϊ0
        int midValue = 0;
        // �����ǰ�ڵ������ӣ���������Ҷ�ӽڵ㣬����ֵ����midValue����
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        // ����������Ҷ�ӽڵ�ĺͣ���midValue��leftSum��rightSum��ӵĽ��
        return midValue + leftSum + rightSum;
    }
}
