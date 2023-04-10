package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94.���������������
 * ����һ���������ĸ��ڵ� root ������ ���� ���� ���� ��
 */
public class Leetcode_94 {
    public List<Integer> inorderTraversalMethodOne(TreeNode root) {
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

    /**
     * ������������
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalMethodTwo(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // ����һ�������б����ڴ洢����������
        Stack<TreeNode> stack = new Stack<>(); // ����һ��ջ���ڱ���������
        if (root == null) { // ������ڵ�Ϊ�գ�ֱ�ӷ��ؿ��б�
            return list;
        }
        TreeNode temp = root; // �����ڵ㸳ֵ��temp
        while (temp != null || !stack.isEmpty()) { // ��temp��Ϊ�ջ�ջ��Ϊ��ʱ��ִ��ѭ�����ڵĲ���
            if (temp != null) { // ���temp��Ϊ��
                stack.push(temp); // ��temp��ջ
                temp=temp.left; // ��tempָ���������ӽڵ�
            }else { // ���tempΪ��
                temp=stack.pop(); // ��ջ��Ԫ�ص�������ֵ��temp
                list.add(temp.val); // ��temp��ֵ��ӵ��б���
                temp=temp.right; // ��tempָ���������ӽڵ�
            }
        }
        return list; // ��������������
    }
}