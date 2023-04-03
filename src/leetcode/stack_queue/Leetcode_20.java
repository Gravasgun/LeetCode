package leetcode.stack_queue;

import java.util.Stack;

/**
 * 20.��Ч������
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ��� s ���ж��ַ����Ƿ���Ч��
 * ��Ч�ַ��������㣺
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ÿ�������Ŷ���һ����Ӧ����ͬ���͵������š�
 */
public class Leetcode_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); // ����һ��ջ���ڴ洢������
        for (char c : s.toCharArray()) { // �����ַ����е�ÿ���ַ�
            if (c == '(' || c == '[' || c == '{') { // ����ַ��������ţ���������ջ��
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') { // ����ַ��������ţ�����ջ��Ԫ���Ƿ�����Ӧ��������
                stack.pop(); // ����ǣ����䵯��ջ
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false; // ����ַ��������Ż�����ջ��Ԫ�ز�ƥ�䣬���ַ�����Ч������false
            }
        }
        return stack.isEmpty(); // �������ַ����󣬼��ջ�Ƿ�Ϊ�գ����Ϊ�գ����ַ�����Ч������true�����򣬷���false
    }
}
