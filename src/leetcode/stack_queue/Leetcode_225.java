package leetcode.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225.�ö���ʵ��ջ
 * �����ʹ����������ʵ��һ�������ȳ���LIFO����ջ����֧����ͨջ��ȫ�����ֲ�����push��top��pop �� empty����
 * ʵ�� MyStack �ࣺ
 * void push(int x) ��Ԫ�� x ѹ��ջ����
 * int pop() �Ƴ�������ջ��Ԫ�ء�
 * int top() ����ջ��Ԫ�ء�
 * boolean empty() ���ջ�ǿյģ����� true �����򣬷��� false ��
 * ע�⣺
 * ��ֻ��ʹ�ö��еĻ������� ���� Ҳ���� push to back��peek/pop from front��size �� is empty ��Щ������
 * ����ʹ�õ�����Ҳ��֧�ֶ��С� �����ʹ�� list ���б����� deque��˫�˶��У���ģ��һ������ , ֻҪ�Ǳ�׼�Ķ��в������ɡ�
 */
public class Leetcode_225 {
    // ��������ʵ��ջ
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    // ���캯������ʼ����������
    public Leetcode_225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // ѹ��һ��Ԫ��
    public void push(int x) {
        // ��Ԫ����ӵ��ڶ������е�ĩβ
        queue2.offer(x);
        // ����һ�������е�����Ԫ�ض��ƶ����ڶ�������֮�����ǵ�˳��ᱻ�������ڶ������оͳ�Ϊ��ջ�Ķ���
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // �����������У�ʹ�ڶ������б�Ϊ��һ������
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // ����ջ��Ԫ��
    public int pop() {
        return queue1.poll();
    }

    // ��ȡջ��Ԫ��
    public int top() {
        return queue1.peek();
    }

    // �ж�ջ�Ƿ�Ϊ��
    public boolean empty() {
        return queue1.isEmpty();
    }
}
