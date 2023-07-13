package leetcode.tree;

public class Leetcode_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // ���root1Ϊ�գ���ֱ�ӷ���root2
        if (root1 == null) {
            return root2;
        }
        // ���root2Ϊ�գ���ֱ�ӷ���root1
        if (root2 == null) {
            return root1;
        }
        // ����һ���µĽڵ㣬�ڵ��ֵΪroot1��root2�ڵ��ֵ֮��
        TreeNode root = new TreeNode(root1.val + root2.val);
        // �ݹ�ϲ�root1��root2��������
        TreeNode leftNode = mergeTrees(root1.left, root2.left);
        // �ݹ�ϲ�root1��root2��������
        TreeNode rightNode = mergeTrees(root1.right, root2.right);
        // ���ϲ����������������������Ϊ�½ڵ����������������
        root.left = leftNode;
        root.right = rightNode;
        // ���غϲ���������ĸ��ڵ�
        return root;
    }
}
