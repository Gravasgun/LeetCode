package leetcode.tree;

/**
 * 700.�����������е�����
 * ����������������BST���ĸ��ڵ� root ��һ������ֵ val��
 * ����Ҫ�� BST ���ҵ��ڵ�ֵ���� val �Ľڵ㡣 �����Ըýڵ�Ϊ���������� ����ڵ㲻���ڣ��򷵻� null ��
 */
public class Leetcode_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        // ������ڵ�Ϊ�գ�����null
        if (root == null) {
            return null;
        }
        // ������ڵ��ֵ���ڸ���ֵ�����ظýڵ�
        if (root.val == val) {
            return root;
        }
        // ���������еݹ�����
        TreeNode leftNode = searchBST(root.left, val);
        // ���������еݹ�����
        TreeNode rightNode = searchBST(root.right, val);
        // ������������ҵ��˽ڵ㣬���ظýڵ�
        if (leftNode != null) {
            return leftNode;
        }
        // ������������ҵ��˽ڵ㣬���ظýڵ�
        if (rightNode != null) {
            return rightNode;
        }
        // �������������û���ҵ��ڵ㣬����null
        return null;
    }
}
