package leetcode.linkedList;

import java.util.Stack;

public class LeetCode_206 {
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

    /**
     * 206.��ת����
     * ���㵥�����ͷ�ڵ�head�����㷴ת���������ط�ת�������
     *
     * @param head
     * @return
     */
    //����һ��ջ
    public ListNode reverseListMethodOne(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        //��ջ
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        //������һ���ڵ㣬����ڵ��Ƿ�ת��ĵ�һ���ڵ�
        ListNode temp = stack.pop();
        //��һ���µĽڵ��������temp����Ϊ�����Ҫ����temp
        ListNode first = temp;
        while (!stack.isEmpty()) {
            ListNode next = stack.pop();
            temp.next = next;
            temp = temp.next;
        }
        //�����һ���ڵ��nextָ��null����Ȼ���ܻ���ֻ�
        temp.next = null;
        return first;
    }

    //��������˫ָ��
    public ListNode reverseListMethodTwo(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return pre;
    }
}
