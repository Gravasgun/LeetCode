package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 94.���������������
 * ����һ���������ĸ��ڵ� root ������ ���� ���� ���� ��
 */
public class Leetcode_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // ����һ�������б����ڴ洢����������
        inOrder(root, list); // ���ø������������������
        return list; // ��������������
    }

    public void inOrder(TreeNode temp, List list) {
        if (temp == null) { // ����ڵ�Ϊ�գ�ֱ�ӷ���
            return;
        }
        inOrder(temp.left, list); // �ȱ���������
        list.add(temp.val); // ����ǰ�ڵ��ֵ��ӵ��б���
        inOrder(temp.right, list); // �ٱ���������
    }
}