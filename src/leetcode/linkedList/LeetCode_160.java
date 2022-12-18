package leetcode.linkedList;

import java.util.HashSet;

public class LeetCode_160 {
    /**
     * 160.�ཻ����
     * ���������������ͷ�ڵ�headA��headB�������ҳ������������������ཻ����ʼ�ڵ㡣����������������ཻ�ڵ㣬����null��
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        //��ÿ���ڵ���ӽ�set��
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        //����B����
        while (headB != null) {
            //���set�а�����headB,��˵��������ڵ㿪ʼ�������ཻ�Ĳ���
            if (set.contains(headB)) {
                return headB;
            }
            //�����������������λ
            headB = headB.next;
        }
        //û�ҵ�������null
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
