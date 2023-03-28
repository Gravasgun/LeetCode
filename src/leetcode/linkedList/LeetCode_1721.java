package leetcode.linkedList;

/**
 * 1721.���������еĽڵ�
 * ���������ͷ�ڵ�head��һ������k������ ����������k���ڵ�͵�����k���ڵ��ֵ�󣬷��������ͷ�ڵ�
 */
public class LeetCode_1721 {
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

    class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            ListNode left = head;//������k���ڵ�
            ListNode right = head;//������k���ڵ�
            //����ѭ���ҵ�������k���ڵ�
            for (int i = 1; i < k; i++) {
                left = left.next;
            }
            //������һ������current����leftָ�룬��Ϊ�����ƶ�leftָ��
            ListNode current = left;
            //������ָ��һ���ƶ�����������k��ָ���ƶ�������ĩβʱ��rightָ��պ��ƶ���������k���ڵ�
            while (current.next != null) {
                right = right.next;
                current = current.next;
            }
            //���������ڵ��ֵ
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
            return head;
        }
    }
}
