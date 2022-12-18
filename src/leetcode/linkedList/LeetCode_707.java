package leetcode.linkedList;

public class LeetCode_707 {
    /**
     * 707.�������
     * ����������ݽṹ
     *
     * @param index
     * @return
     */
    int size;
    ListNode head;

    public LeetCode_707() {
        this.size = 0;
        head = new ListNode(0);
    }

    /**
     * ��ȡ�����е�index���ڵ��ֵ�����������Ч���򷵻�-1��
     *
     * @param index
     * @return
     */
    public int get(int index) {
        //���index�Ƿ�������-1
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    /**
     * ������ĵ�һ��Ԫ��֮ǰ���һ��ֵΪval�Ľڵ㡣������½ڵ㽫��Ϊ����ĵ�һ���ڵ㡣
     *
     * @param val
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * ��ֵΪval�Ľڵ�׷�ӵ���������һ��Ԫ�ء�
     *
     * @param val
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * �������еĵ� index���ڵ�֮ǰ���ֵΪval�Ľڵ㡣���index��������ĳ��ȣ���ýڵ㽫���ӵ������ĩβ��
     * ���index���������ȣ��򲻻����ڵ㡣���indexС��0������ͷ������ڵ㡣
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            size = 0;
        }
        size++;
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        ListNode newAdd = new ListNode(val);
        newAdd.next = temp.next;
        temp.next = newAdd;
    }

    /**
     * �������index��Ч����ɾ�������еĵ�index���ڵ㡣
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

}
