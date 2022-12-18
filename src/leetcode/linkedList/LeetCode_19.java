package leetcode.linkedList;

public class LeetCode_19 {
    /**
     * 19.ɾ�������е�����N��Ԫ��
     * ����һ������ɾ������ĵ�����n����㣬���ҷ��������ͷ��㡣
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0, head);
        ListNode temp = newHead;
        //�õ���������size
        int length = getLength(head);
        //�ƶ�temp��ɾ��Ԫ�ص�ǰһ��Ԫ��
        for (int i = 1; i < length - n + 1; i++) {
            temp = temp.next;
        }
        //ɾ��
        temp.next = temp.next.next;
        return newHead.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
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
