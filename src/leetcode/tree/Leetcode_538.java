package leetcode.tree;

/**
 * 538.�Ѷ���������ת��Ϊ�ۼ���
 * �������� ���� ���ĸ��ڵ㣬�����Ľڵ�ֵ������ͬ�����㽫��ת��Ϊ�ۼ�����Greater Sum Tree����ʹÿ���ڵ� node ����ֵ����ԭ���д��ڻ���� node.val ��ֵ֮�͡�
 * <p>
 * ����һ�£�������������������Լ��������
 * <p>
 * �ڵ���������������� С�� �ڵ���Ľڵ㡣
 * �ڵ���������������� ���� �ڵ���Ľڵ㡣
 * ��������Ҳ�����Ƕ�����������
 */
public class Leetcode_538 {
    int pre;  // ���ڱ���֮ǰ����Ľڵ�ֵ�ĺ�

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;  // ������ڵ�Ϊ�գ�ֱ�ӷ���null
        }
        convert(root);  // ִ��ת������
        return root;  // ����ת����ĸ��ڵ�
    }

    private void convert(TreeNode root) {
        if (root == null) {
            return;  // �����ǰ�ڵ�Ϊ�գ�ֱ�ӷ���
        }
        convert(root.right);  // �ݹ鴦�����������ȴ���ϴ�Ľڵ�
        root.val += pre;  // ����ǰ�ڵ��ֵ����֮ǰ����Ľڵ�ֵ֮��
        pre = root.val;  // ����preΪ��ǰ�ڵ�ֵ������һ�δ���ʹ��
        convert(root.left);  // �ݹ鴦���������������С�Ľڵ�
    }
}
