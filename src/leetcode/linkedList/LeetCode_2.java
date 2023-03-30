package leetcode.linkedList;

import org.junit.Test;

import java.util.Stack;

public class LeetCode_2 {
    /**
     * 2.�������
     * ���������ǿյ�������ʾ�����Ǹ�����������ÿλ���ֶ��ǰ�������ʽ�洢�ģ�
     * ����ÿ���ڵ�ֻ�ܴ洢һλ���֡����㽫��������ӣ�������ͬ��ʽ����һ����ʾ�͵�����
     * ����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
     * �ⷨ��
     * ���ǿ���ģ���˹��ӷ��Ĺ��̣��ӵ�λ����λ��λ��ӣ���¼�½�λֵ��
     * �ڱ�����ɺ�������н�λ����ô��Ҫ����λֵ��ӵ���������λ��
     * ʱ�临�Ӷȣ�O(max(m,n))������ m �� n �ֱ�Ϊ��������ĳ��ȡ�
     * �ռ临�Ӷȣ�O(max(m,n))���½�����ĳ���Ϊ�ϳ������� + 1��
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(); // ����һ��������ڵ㣬��Ϊ��������ͷ���ڵ�
        ListNode temp = pre; // ���ڱ�����������ָ�룬��ʼָ��ͷ���ڵ�
        int carry = 0; // ��λֵ����ʼΪ 0
        while (l1 != null || l2 != null) { // �ӵ�λ����λ��λ���
            int x = l1 == null ? 0 : l1.val; // ��ȡ��ǰλ����ֵ���������ڵ��Ѿ������꣬��ô��ֵΪ 0
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry; // ��Ӳ����Ͻ�λֵ
            carry = sum / 10; // �����λֵ
            temp.next = new ListNode(sum % 10); // ����һ���µĽڵ㣬�洢��ǰλ����ֵ
            temp = temp.next; // ָ����ǰ�ƶ�
            if (l1 != null) { // ������� l1 ���нڵ㣬ָ����ǰ�ƶ�
                l1 = l1.next;
            }
            if (l2 != null) { // ������� l2 ���нڵ㣬ָ����ǰ�ƶ�
                l2 = l2.next;
            }
        }
        if (carry > 0) { // ������н�λ����ô��Ҫ����λֵ��ӵ���������λ
            temp.next = new ListNode(carry);
        }
        return pre.next; // ���ؽ�������ͷ���ڵ����һ���ڵ�
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
}
