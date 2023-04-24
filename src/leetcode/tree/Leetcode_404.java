package leetcode.tree;

import java.util.Stack;

public class Leetcode_404 {
    /**
     * 404.��Ҷ��֮��
     * �����������ĸ��ڵ�root������������Ҷ��֮�͡�
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeavesMethodOne(TreeNode root) {
        // �����ǰ�ڵ�Ϊ�գ��򷵻�0
        if (root == null) {
            return 0;
        }
        // �ݹ������������������Ҷ�ӽڵ�ĺͣ��洢��leftSum������
        int leftSum = sumOfLeftLeavesMethodOne(root.left);
        // �ݹ������������������Ҷ�ӽڵ�ĺͣ��洢��rightSum������
        int rightSum = sumOfLeftLeavesMethodOne(root.right);
        // ����һ������midValue��ʾ��ǰ�ڵ��ֵ��Ĭ��Ϊ0
        int midValue = 0;
        // �����ǰ�ڵ������ӣ���������Ҷ�ӽڵ㣬����ֵ����midValue����
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        // ����������Ҷ�ӽڵ�ĺͣ���midValue��leftSum��rightSum��ӵĽ��
        return midValue + leftSum + rightSum;
    }

    /**
     * ������������
     * @param root
     * @return
     */
    public int sumOfLeftLeavesMethodTwo(TreeNode root) {
        // �����ǰ�ڵ�Ϊ�գ��򷵻�0
        if (root == null) {
            return 0;
        }
        // �������result��������Ҷ�ӽڵ�ĺ�
        int result = 0;
        // ����һ����ջ���洢��Ҫ�����Ľڵ�
        Stack<TreeNode> stack = new Stack<>();
        // �����ڵ�����ջ��
        stack.push(root);
        // ��ʼ��������������
        while (!stack.isEmpty()) {
            // ȡ����ջ�е����һ���ڵ㣬���Ӷ�ջ���Ƴ�
            TreeNode temp = stack.pop();
            // �жϵ�ǰ�ڵ�����ӽڵ��Ƿ�ΪҶ�ӽڵ㣬����ǣ�����Ҷ�ӽڵ��ֵ�ӵ������
            if (temp.left != null && temp.left.left == null && temp.left.right == null) {
                result += temp.left.val;
            }
            // ����ǰ�ڵ�����ӽڵ�����ջ��
            if (temp.right != null) {
                stack.push(temp.right);
            }
            // ����ǰ�ڵ�����ӽڵ�����ջ��
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        // ���ؽ��
        return result;
    }
}
