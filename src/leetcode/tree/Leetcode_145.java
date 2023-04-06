package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 145.�������ĺ������
 * ����һ�ö������ĸ��ڵ� root ��������ڵ�ֵ�� ������� ��
 */
public class Leetcode_145 {
    /**
     * ������������������ر������
     *
     * @param root �������ĸ��ڵ�
     * @return �������
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list); // ���ú����������
        return list; // ���ر������
    }

    /**
     * ������������������������������ list ��
     *
     * @param temp ��ǰ�ڵ�
     * @param list �洢����������б�
     */
    public void postOrder(TreeNode temp, List<Integer> list) {
        if (temp == null) { // �����ǰ�ڵ�Ϊ�գ�ֱ�ӷ���
            return;
        }
        postOrder(temp.left, list); // �ݹ����������
        postOrder(temp.right, list); // �ݹ����������
        list.add(temp.val); // ����ǰ�ڵ��ֵ��ӵ����������
    }
}
