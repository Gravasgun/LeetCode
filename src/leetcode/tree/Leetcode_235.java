package leetcode.tree;

/**
 * 235.�����������������������
 * ����һ������������, �ҵ�����������ָ���ڵ������������ȡ�
 * �ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ���
 */
public class Leetcode_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // ������ڵ�Ϊ�գ�����null
        if (root == null) {
            return null;
        }
        // ������ڵ��ֵ��p��q�ڵ��ֵ����˵��p��q�ڵ㶼���������У��ݹ����������
        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            // ������������ҵ�������������ȣ���ֱ�ӷ���
            if (left != null) {
                return left;
            }
        }
        // ������ڵ��ֵ��p��q�ڵ��ֵ��С��˵��p��q�ڵ㶼���������У��ݹ����������
        if (root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // ������������ҵ�������������ȣ���ֱ�ӷ���
            if (right != null) {
                return right;
            }
        }
        // ��ǰ�ڵ��ֵ����p��q�ڵ�֮�䣬���Ե�ǰ�ڵ����p��q�ڵ�������������
        return root;
    }
}
