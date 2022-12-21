package leetcode.linkedList;

import org.junit.Test;

import java.util.Stack;

public class LeetCode_2 {
    /**
     * 2.�������
     * ���������ǿյ�������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ�������ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢һλ���֡�
     * ���㽫��������ӣ��������򷵻�һ����ʾ�͵�����
     * ����������������0��ͷ��
     * <p>
     * ������������ֳ���long�͵�ʱ������
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //stack1���l1
        Stack<ListNode> stack1 = new Stack<>();
        //stack2���l2
        Stack<ListNode> stack2 = new Stack<>();
        //stack3���l1��l2�ĺ�
        Stack<ListNode> stack3 = new Stack<>();
        //str1����ƴ��l1
        StringBuilder str1 = new StringBuilder();
        //str2����ƴ��l2
        StringBuilder str2 = new StringBuilder();
        //l1��ջ
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        //l2��ջ
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        //l1��ջ
        while (!stack1.isEmpty()) {
            //��ջ��ʱ��ƴ��
            str1.append(stack1.pop().val);
        }

        while (!stack2.isEmpty()) {
            //��ջ��ʱ��ƴ��
            str2.append(stack2.pop().val);
        }
        //���
        long sum = Long.parseLong(String.valueOf(str1)) + Long.parseLong(String.valueOf(str2));
        //���ͷ�ת
        char[] sumChars = String.valueOf(sum).toCharArray();
        for (int i = 0; i < sumChars.length; i++) {
            stack3.push(new ListNode(Integer.parseInt(String.valueOf(sumChars[i]))));
        }
        ListNode first = stack3.pop();
        ListNode temp = first;
        while (!stack3.isEmpty()) {
            temp.next = stack3.pop();
            temp = temp.next;
        }
        return first;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void test() {
        ListNode list1 = new ListNode(9, new ListNode(9, new ListNode(9, null)));
        ListNode list2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(1, null))));
        ListNode first = addTwoNumbers(list1, list2);
        while (first != null) {
            System.out.print(first.val + " ");
            first = first.next;
        }
    }
}
