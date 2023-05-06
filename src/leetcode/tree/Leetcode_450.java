package leetcode.tree;

/**
 * 450.ɾ�������������еĽڵ�
 * ����һ�������������ĸ��ڵ� root ��һ��ֵ key��ɾ�������������е� key ��Ӧ�Ľڵ㣬����֤���������������ʲ��䡣���ض������������п��ܱ����£��ĸ��ڵ�����á�
 * һ����˵��ɾ���ڵ�ɷ�Ϊ�������裺
 * �����ҵ���Ҫɾ���Ľڵ㣻
 * ����ҵ��ˣ�ɾ������
 */
public class Leetcode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        // ���������
        // 1.������ڵ�Ϊ�գ�˵��û�ҵ�Ҫɾ���Ľڵ�
        if (root == null) {
            return null;
        }
        // ������ڵ��ֵ����Ҫɾ����ֵ
        if (root.val == key) {
            // 2.������ڵ���Ҷ�ӽڵ㣬�������ӽڵ㶼Ϊ��
            if (root.left == null && root.right == null) {
                return null; // ֱ�ӷ���null����ʾɾ���ýڵ�
            }
            // 3.������ڵ�ֻ�����ӽڵ�
            else if (root.left == null && root.right != null) {
                return root.right; // �������ӽڵ㣬��ʾɾ���ýڵ�
            }
            // 4.������ڵ�ֻ�����ӽڵ�
            else if (root.left != null && root.right == null) {
                return root.left; // �������ӽڵ㣬��ʾɾ���ýڵ�
            }
            // 5.������ڵ�������ӽڵ��������ӽڵ�
            else {
                TreeNode temp = root; // ����һ����ʱ�ڵ㣬����Ѱ������������С�Ľڵ�
                temp = temp.right; // �Ƚ���ʱ�ڵ�ָ�����ӽڵ�
                while (temp.left != null) { // ѭ���ҵ�����������С�Ľڵ�
                    temp = temp.left;
                }
                temp.left = root.left; // �����ڵ���������ӵ�����������С�ڵ����������
                return root.right; // �������ӽڵ㣬��ʾɾ���ýڵ�
            }
        }
        // return���߼��ǣ���ݹ����һ�㷵��ɾ����ĸ��ڵ㣬���磺
        // ���ݹ鵽Ҷ�ӽڵ�ʱ���᷵�� null��Ȼ�󽫸� null ֵ���ظ���Ҷ�ӽڵ�ĸ��ڵ㡣���������ڵ�Ϳ��Խ��յ��ӽڵ�ķ���ֵ�������Լ������ӽڵ�����ӽڵ�ָ��÷���ֵ���Ӷ����ɾ��������
        // ���µ����д����ʾ����ǰ�ڵ�ĸ��ڵ�����ӽڵ�ķ���ֵ����ָ���ӽڵ�
        // ������ڵ��ֵ������Ҫɾ����ֵ����ݹ�ɾ�����������еĽڵ�
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root; // ���ظ��ڵ�
    }
}
