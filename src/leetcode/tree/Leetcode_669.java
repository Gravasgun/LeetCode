package leetcode.tree;

/**
 * 669.�޼�����������
 * ��������������ĸ��ڵ� root ��ͬʱ������С�߽�low �����߽� high��ͨ���޼�������������ʹ�����нڵ��ֵ��[low, high]�С�
 * �޼��� ��Ӧ�� �ı䱣�������е�Ԫ�ص���Խṹ (�������û�б��Ƴ���ԭ�еĸ����Ӵ���ϵ��Ӧ������)�� ����֤�������� Ψһ�Ĵ� ��
 * ���Խ��Ӧ�������޼��õĶ������������µĸ��ڵ㡣ע�⣬���ڵ���ܻ���ݸ����ı߽緢���ı䡣
 */
public class Leetcode_669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // ������ڵ�Ϊ�գ�����null
        if (root == null) {
            return null;
        }
        // ������ڵ��ֵ����[low, high]��Χ��
        // ������ڵ��ֵС��low��˵�����ڵ㼰��������������[low, high]��Χ�ڣ��ݹ��޼�������
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // ������ڵ��ֵ����high��˵�����ڵ㼰��������������[low, high]��Χ�ڣ��ݹ��޼�������
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // ������ڵ��ֵ��[low, high]��Χ�ڣ��ݹ��޼���������������
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        // �����޼���ĸ��ڵ�
        return root;
    }
}
