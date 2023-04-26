package leetcode.tree;

/**
 * 572.��һ����������
 * �������ö����� root �� subRoot ������ root ���Ƿ������ subRoot ������ͬ�ṹ�ͽڵ�ֵ��������������ڣ����� true �����򣬷��� false ��
 * ������ tree ��һ���������� tree ��ĳ���ڵ������ڵ�����к���ڵ㡣tree Ҳ���Կ����������һ��������
 */
public class Leetcode_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        // �жϵ�ǰ���������Ƿ���ͬ
        boolean isSameTree = isSameTree(root, subRoot);
        if (isSameTree) {
            return true;
        } else {
            //�ٵݹ�Ƚ�����һ������������������������һ�����Ƿ���ͬ
            boolean isLeftSubTree = isSubtree(root.left, subRoot);
            boolean isRightSubTree = isSubtree(root.right, subRoot);
            return isLeftSubTree || isRightSubTree;
        }
    }

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
