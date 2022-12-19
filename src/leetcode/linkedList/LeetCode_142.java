package leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_142 {
    /**
     * 142.��������II
     *����һ�������ͷ�ڵ�head����������ʼ�뻷�ĵ�һ���ڵ㡣��������޻����򷵻�null��
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            //������ʧ�ܣ�˵����ǰ�ڵ�����뻷�ĵ�һ���ڵ�
            if (!set.add(head)) {
                return head;
            }
            //������λ
            head = head.next;
        }
        //�޻�������ͻ�����whileѭ��
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
