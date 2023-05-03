package leetcode.tree;

/**
 * 236.�������������������
 * ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 * �ٶȰٿ�������������ȵĶ���Ϊ��
 * �������и��� T �������ڵ� p��q������������ȱ�ʾΪһ���ڵ� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
 */
public class Leetcode_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // ������ڵ�Ϊ�գ����߸��ڵ����p��q�ڵ㣬�򷵻ظ��ڵ�
        if (root == null || root == p || root == q) {
            return root;
        }
        // �ݹ��ҳ���������p��q������������Ƚڵ�
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // �ݹ��ҳ���������p��q������������Ƚڵ�
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // �������������������û���ҵ�p��q������������Ƚڵ㣬����null
        if (left == null && right == null) {
            return null;
            // ���������û���ҵ�p��q������������Ƚڵ㣬���������ҵ��ˣ��򷵻��������Ľ��
        } else if (left == null && right != null) {
            return right;
            // ���������û���ҵ�p��q������������Ƚڵ㣬���������ҵ��ˣ��򷵻��������Ľ��
        } else if (left != null && right == null) {
            return left;
            // ��������������ҵ���p��q������������Ƚڵ㣬�򷵻ظ��ڵ�
        } else {
            return root;
        }
    }
}
