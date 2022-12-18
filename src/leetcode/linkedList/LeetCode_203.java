package leetcode.linkedList;

public class LeetCode_203 {
    /**
     * 203.�Ƴ�����Ԫ��
     * ����һ�������ͷ�ڵ�head��һ������val������ɾ����������������Node.val==val�Ľڵ㣬�������µ�ͷ�ڵ㡣
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        //����һ���µĽڵ㣬����ڵ��nextָ��head
        ListNode newHead = new ListNode(0, head);
        //��Ϊ֮����Ҫ�õ�����ڵ��next�����Դ���һ����ʱ�ڵ������ƶ�
        ListNode temp = newHead;
        //temp��ͷ�ڵ��ǰһ���ڵ㣬�����ͻ��ų�ͷ�ڵ��ֵҲ����ɾ�����������
        while (temp.next != null) {
            //�����ǰ�ڵ��next��val��������
            if (temp.next.val == val) {
                //ɾ���ڵ�
                temp.next = temp.next.next;
            } else {
                //����ƶ�һλ
                temp = temp.next;
            }
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
