package leetcode.linkedList;

import java.util.Stack;

public class Offer_006 {
    /**
     * ��ָoffer_006.��β��ͷ��ӡ����
     * ����һ�������ͷ�ڵ㣬��β��ͷ����������ÿ���ڵ��ֵ�������鷵�أ���
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        /**
         * ջ���ص��Ǻ���ȳ��������ѹ��ջ��Ԫ�����ȵ��������ǵ�ջ����һ�ص㣬ʹ��ջ������Ԫ��˳���ã���ת������
         * �������ͷ�ڵ㿪ʼ�����ν�ÿ���ڵ�ѹ��ջ�ڣ�Ȼ�����ε���ջ�ڵ�Ԫ�ز��洢�������С�
         */
        //����һ��ջ�����ڴ洢����Ľڵ�
        Stack<ListNode> stack = new Stack<>();
        //��ָ��ָ���Ԫ�طǿ�ʱ���ظ����в�����
        while (head != null) {
            //��ָ��ָ��Ľڵ�ѹ��ջ��
            stack.push(head);
            //��ָ���Ƶ���ǰ�ڵ����һ���ڵ�
            head = head.next;
        }
        //���ջ�Ĵ�Сsize
        int size = stack.size();
        //����һ������nums�����СΪsize
        int[] nums = new int[size];
        //��������
        for (int i = 0; i < size; i++) {
            nums[i] = stack.pop().val;
        }
        return nums;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
