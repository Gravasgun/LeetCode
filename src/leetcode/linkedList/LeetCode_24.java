package leetcode.linkedList;

public class LeetCode_24 {
    /**
     * 24.�������������еĽڵ�
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0,head);
        ListNode temp = newHead;
        while (temp.next != null && temp.next.next != null) {
            //��node1������temp.next
            ListNode node1 = temp.next;
            //��node2������temp.next.net
            ListNode node2 = temp.next.next;
            ////��node3������node2.next
            ListNode node3 = node2.next;
            //��temp.nextָ��node2(node2��ʱ��temp.next.next)
            temp.next = node2;
            //��node2.nextָ��node1(node1��ʱ��temp.next)
            node2.next = node1;
            //��node1.nextָ��֮ǰnode2��next(Ҳ����node3��
            //֮���Ե�������һ��node3����������Ϊ����һ��node2.next�ᷢ���仯,�����ڱ仯֮ǰҪ��node3����δ��֮ǰ��next)
            node1.next = node3;
            //���temp�����ƶ���λ
            temp = node2.next;
        }
        return newHead.next;
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
