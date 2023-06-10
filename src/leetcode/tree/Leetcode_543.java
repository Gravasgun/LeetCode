package leetcode.tree;

/**
 * 543.��������ֱ��
 * ����һ�ö������ĸ��ڵ㣬���ظ����� ֱ�� ��
 * �������� ֱ�� ��ָ�������������ڵ�֮���·���� ���� ��
 * ����·�����ܾ���Ҳ���ܲ��������ڵ� root ��
 * ���ڵ�֮��·���� ���� ������֮�������ʾ��
 */
public class Leetcode_543 {
    // ��ʼ�����ֱ��Ϊ��Сֵ
    int max = Integer.MIN_VALUE;

    /**
     * �����������ֱ��
     *
     * @param root ���ڵ�
     * @return ��������ֱ��
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // ������ڵ�Ϊ�գ�ֱ��Ϊ 0
        if (root == null) {
            return 0;
        }
        // ���к����������ֱ��
        // û�з���ֵ����Ϊ ֻ��Ҫ�ڱ�����ö�������ʱ���¼ÿһ���ڵ�����ֱ��
        postOrder(root);
        // �������ֱ��
        return max;
    }

    /**
     * �����������ڵ����ȣ����������ֱ��
     *
     * @param temp ��ǰ�ڵ�
     * @return ��ǰ�ڵ�����
     */
    private int postOrder(TreeNode temp) {
        // �����ǰ�ڵ�Ϊ�գ����Ϊ 0
        if (temp == null) {
            return 0;
        }
        // �ݹ���������������
        int left = postOrder(temp.left);
        // �ݹ���������������
        int right = postOrder(temp.right);
        // �������ֱ����ȡÿһ���ڵ�����ֱ����
        // �����������ڵ�Ͳ��������ڵ��������
        max = Math.max(max, left + right);
        // ���ص�ǰ�ڵ����ȣ�������������������Ƚϴ��ֵ��һ��
        return Math.max(left, right) + 1;
    }
}