package leetcode.tree;

/**
 * 98.��֤����������
 * ����һ���������ĸ��ڵ� root ���ж����Ƿ���һ����Ч�Ķ�����������
 * ��Ч �����������������£�
 * �ڵ��������ֻ���� С�� ��ǰ�ڵ������
 * �ڵ��������ֻ���� ���� ��ǰ�ڵ������
 * �������������������������Ҳ�Ƕ�����������
 */
public class Leetcode_98 {
    public boolean isValidBST(TreeNode root) {
        // ��ʼ���ã������޶�Ϊnull
        return isValidBST(root, null, null);
    }

    // �ݹ麯�����ж���tempΪ���ڵ�Ķ������Ƿ�Ϊһ�úϷ���BST��lower��upper��ʾ������
    private boolean isValidBST(TreeNode temp, Integer lower, Integer upper) {
        // ����ڵ�Ϊ�գ�����true
        if (temp == null) {
            return true;
        }
        // ����ڵ�ֵС�ڵ���lower����ڵ���upper��������BST�����ʣ�����false
        if (lower != null && temp.val <= lower) {
            return false;
        }
        if (upper != null && temp.val >= upper) {
            return false;
        }
        // �ݹ������������Ƿ��ǺϷ���BST����������������temp.val��Ϊ���ޣ���������������temp.val��Ϊ����
        return isValidBST(temp.left, lower, temp.val) && isValidBST(temp.right, temp.val, upper);
    }
}
