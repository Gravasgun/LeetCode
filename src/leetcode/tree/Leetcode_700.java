package leetcode.tree;

public class Leetcode_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        // ������ڵ�Ϊ�գ�����null
        if (root == null) {
            return null;
        }
        // ������ڵ��ֵ���ڸ���ֵ�����ظýڵ�
        if (root.val == val) {
            return root;
        } else if (val < root.val) {
            // ���������еݹ�����
            TreeNode leftNode = searchBST(root.left, val);
            // ������������ҵ��˽ڵ㣬���ظýڵ�
            if (leftNode != null) {
                return leftNode;
            }
        } else {
            // ���������еݹ�����
            TreeNode rightNode = searchBST(root.right, val);
            // ������������ҵ��˽ڵ㣬���ظýڵ�
            if (rightNode != null) {
                return rightNode;
            }
        }
        // �������������û���ҵ��ڵ㣬����null
        return null;
    }
}
