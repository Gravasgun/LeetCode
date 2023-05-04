package leetcode.tree;

/**
 * 701.�����������еĲ������
 * ����������������BST���ĸ��ڵ� root ��Ҫ�������е�ֵ value ����ֵ���������������
 * ���ز��������������ĸ��ڵ㡣 �������� ��֤ ����ֵ��ԭʼ�����������е�����ڵ�ֵ����ͬ��
 */
public class Leetcode_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // ������ڵ�Ϊ�գ�˵������Ϊ�գ�ֱ�Ӵ���һ���µĽڵ���Ϊ���ڵ�
        if (root == null) {
            return new TreeNode(val);
        }
        // ����������ֵС�ڸ��ڵ��ֵ��˵��������Ľڵ�Ӧ������������
        if (root.val > val) {
            // �ݹ���øú�����������ڵ�����ӽڵ���Ϊ�µĸ��ڵ�
            TreeNode left = insertIntoBST(root.left, val);
            // �����ص����������뵽���ڵ�����ӽڵ���
            root.left = left;
        }
        // ����������ֵ���ڸ��ڵ��ֵ��˵��������Ľڵ�Ӧ������������
        if (root.val < val) {
            // �ݹ���øú�����������ڵ�����ӽڵ���Ϊ�µĸ��ڵ�
            TreeNode right = insertIntoBST(root.right, val);
            // �����ص����������뵽���ڵ�����ӽڵ���
            root.right = right;
        }
        // ���ظ��ڵ�
        return root;
    }
}
