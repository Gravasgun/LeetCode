package leetcode.stack_queue;

import java.util.Stack;

/**
 * 232.��ջʵ�ֶ���
 * �����ʹ������ջʵ�������ȳ����С�����Ӧ��֧��һ�����֧�ֵ����в�����push��pop��peek��empty����
 * ʵ�� MyQueue �ࣺ
 * void push(int x) ��Ԫ�� x �Ƶ����е�ĩβ
 * int pop() �Ӷ��еĿ�ͷ�Ƴ�������Ԫ��
 * int peek() ���ض��п�ͷ��Ԫ��
 * boolean empty() �������Ϊ�գ����� true �����򣬷��� false
 * ˵����
 * �� ֻ�� ʹ�ñ�׼��ջ���� ���� Ҳ����ֻ�� push to top, peek/pop from top, size, �� is empty �����ǺϷ��ġ�
 * ����ʹ�õ�����Ҳ��֧��ջ�������ʹ�� list ���� deque��˫�˶��У���ģ��һ��ջ��ֻҪ�Ǳ�׼��ջ�������ɡ�
 */
public class Leetcode_232 {
    Stack<Integer> inStack;  // ����һ����ջ�����ڴ洢������е�Ԫ��
    Stack<Integer> outStack; // ����һ����ջ�����ڴ洢�������е�Ԫ��

    public Leetcode_232() {  // ���캯������ʼ����ջ�ͳ�ջ
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {  // ��Ԫ��������еķ���
        inStack.push(x);  // ֱ�ӽ�Ԫ�������ջ
    }

    public int pop() {  // �Ӷ����е���Ԫ�صķ���
        if (outStack.isEmpty()) {  // �����ջΪ��
            while (!inStack.isEmpty()) {  // ����ջ�е�Ԫ��ȫ�������ջ
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();  // �ӳ�ջ�е��������е�Ԫ��
    }

    public int peek() {  // �鿴��������һ��Ԫ�صķ���
        if (outStack.isEmpty()) {  // �����ջΪ��
            while (!inStack.isEmpty()) {  // ����ջ�е�Ԫ��ȫ�������ջ
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();  // ���س�ջ������Ԫ�أ��������е���һ��Ԫ��
    }

    public boolean empty() {  // �������Ƿ�Ϊ�յķ���
        return outStack.isEmpty() && inStack.isEmpty();  // ֻ�е���ջ�ͳ�ջ��Ϊ��ʱ�����в�Ϊ��
    }
}