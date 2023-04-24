package leetcode.tree;

/**
 * 100.��ͬ����
 * �������ö������ĸ��ڵ�p��q����дһ���������������������Ƿ���ͬ��
 * ����������ڽṹ����ͬ�����ҽڵ������ͬ��ֵ������Ϊ��������ͬ�ġ�
 */
public class Leetcode_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // ����������ĵ�ǰ�ڵ㶼�� null������������ͬ������ true
        if (p == null && q == null) {
            return true;
        }
        // ���ֻ��һ�����ĵ�ǰ�ڵ��� null������������ͬ������ false
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        // ����������ĵ�ǰ�ڵ��ֵ��ͬ������������ͬ������ false
        if (p.val != q.val) {
            return false;
        }
        // �ݹ�Ƚ������������������������Ƿ���ͬ
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
