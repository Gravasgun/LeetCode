package leetcode.stack_queue;

import java.util.Stack;

/**
 * 1047.ɾ���ַ����е����������ظ���
 * ������Сд��ĸ��ɵ��ַ��� S���ظ���ɾ��������ѡ��������������ͬ����ĸ����ɾ�����ǡ�
 * �� S �Ϸ���ִ���ظ���ɾ��������ֱ���޷�����ɾ����
 * ����������ظ���ɾ�������󷵻����յ��ַ������𰸱�֤Ψһ��
 */
public class Leetcode_1047 {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray(); // �������ַ���תΪ�ַ�����
        Stack<Character> stack = new Stack<>(); // ����һ��ջ���洢�ַ�
        for (int i = 0; i < chars.length; i++) { // �����ַ�����
            if (stack.isEmpty()) { // ���ջΪ�գ�����ǰ�ַ�ѹ��ջ��
                stack.push(chars[i]);
                continue;
            }
            if (stack.peek() != chars[i]) { // ���ջ���ַ��뵱ǰ�ַ���ͬ������ǰ�ַ�ѹ��ջ��
                stack.push(chars[i]);
                continue;
            }
            if (stack.peek() == chars[i]) { // ���ջ���ַ��뵱ǰ�ַ���ͬ������ջ���ַ�
                stack.pop();
            }
        }
        StringBuilder stringBuilder = new StringBuilder(); // ����һ��StringBuilder����
        int size = stack.size(); // ��ȡջ�Ĵ�С
        for (int i = 0; i < size; i++) { // ���δ�ջ����ʼȡ��ջ�е��ַ�
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString(); // ��StringBuilder��ת�󷵻��ַ���
    }
}
