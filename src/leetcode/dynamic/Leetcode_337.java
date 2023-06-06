package leetcode.dynamic;

import leetcode.tree.TreeNode;

/**
 * 337.��ҽ���III
 * С͵�ַ�����һ���µĿ����Եĵ������������ֻ��һ����ڣ����ǳ�֮Ϊ root ��
 * ���� root ֮�⣬ÿ����������ֻ��һ��������������֮������һ�����֮�󣬴�����С͵��ʶ��������ط������з��ݵ�����������һ�ö���������
 * ��� ����ֱ�������ķ�����ͬһ�����ϱ���� �����ݽ��Զ�������
 * ������������ root ������ �ڲ���������������� ��С͵�ܹ���ȡ����߽�� ��
 */
public class Leetcode_337 {
    public int rob(TreeNode root) {
        // ���ø�������robTree�����Ը��ڵ�Ϊ����������ٽ��
        int[] result = robTree(root);
        // ���ز����ٸ��ڵ�����ٸ��ڵ���������µĽϴ�ֵ
        return Math.max(result[0], result[1]);
    }

    // ���������������Ե�ǰ�ڵ�Ϊ���ڵ�Ķ������е�������ٽ��
    private int[] robTree(TreeNode temp) {
        if (temp == null) {
            // ����ǰ�ڵ�Ϊ�գ��򷵻س���Ϊ2�����飬��ʾ�����ٺ����ٵ�ǰ�ڵ��������Ϊ0
            return new int[]{0, 0};
        }
        // �ݹ��������������������������ٽ��
        int[] leftResult = robTree(temp.left);
        int[] rightResult = robTree(temp.right);
        // value1��ʾ�����ٵ�ǰ�ڵ㣬ȡ��������������������ٽ��֮��
        int value1 = Math.max(leftResult[0], leftResult[1]) + Math.max(rightResult[0], rightResult[1]);
        // value2��ʾ���ٵ�ǰ�ڵ㣬ȡ��ǰ�ڵ�ֵ���������������ٵ������������������ٵ������֮��
        int value2 = temp.val + leftResult[0] + rightResult[0];
        // ���ص�ǰ�ڵ��������ٽ��ֱ��ʾ�����ٵ�ǰ�ڵ�����ٵ�ǰ�ڵ���������
        return new int[]{value1, value2};
    }
}
