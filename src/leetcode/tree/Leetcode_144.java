package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 144.��������ǰ�����
 * ����������ĸ��ڵ� root ���������ڵ�ֵ�� ǰ�� ������
 */
public class Leetcode_144 {

    /**
     * �Ը����Ķ�����ִ����������������ر��������
     *
     * @param root �����Ķ��������ڵ�
     * @return ����������
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // ����һ��ArrayList�������ڴ�ű������
        List<Integer> list = new ArrayList<>();
        // ����preOrder������ִ���������
        preOrder(root, list);
        // ���ر������
        return list;
    }

    /**
     * �ݹ�������������������������ڸ�����List�����С�
     *
     * @param temp ��ǰ�������Ľڵ�
     * @param list ���ڴ�ű��������List����
     */
    public void preOrder(TreeNode temp, List<Integer> list) {
        // �����ǰ�ڵ�Ϊ�գ�ֱ�ӷ���
        if (temp == null) {
            return;
        }
        // ����ǰ�ڵ��ֵ����List������
        list.add(temp.val);
        // �ݹ������ǰ�ڵ��������
        preOrder(temp.left, list);
        // �ݹ������ǰ�ڵ��������
        preOrder(temp.right, list);
    }
}
