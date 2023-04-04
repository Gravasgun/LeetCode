package leetcode.stack_queue;

import java.util.Stack;

/**
 * 150.�沨�����ʽ��ֵ
 * ����һ���ַ������� tokens ����ʾһ������ �沨����ʾ�� ��ʾ���������ʽ��
 * �������ñ��ʽ������һ����ʾ���ʽֵ��������
 * ע�⣺
 * ��Ч�����Ϊ '+'��'-'��'*' �� '/' ��
 * ÿ����������������󣩶�������һ������������һ�����ʽ��
 * ��������֮��ĳ������� ����ض� ��
 * ���ʽ�в����������㡣
 * ������һ�������沨����ʾ����ʾ���������ʽ��
 * �𰸼������м������������ 32 λ ������ʾ��
 */
public class Leetcode_150 {
    public int evalRPN(String[] tokens) {
        // ����һ��ջ���洢��������������
        Stack<String> stack = new Stack<>();

        // �����沨�����ʽ
        for (String s : tokens) {
            // �����ǰ�ַ����ǲ�����������ջ��������Ԫ�ؽ�������
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                // ����ջ��������Ԫ��
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());

                // �жϲ��������ͣ�������Ӧ�����㣬�������ѹ��ջ��
                if (s.equals("+")) {
                    int num3 = num1 + num2;
                    stack.push(String.valueOf(num3));
                    continue; // ���������Ĵ��룬������һ��ѭ��
                }
                if (s.equals("-")) {
                    int num3 = num2 - num1;
                    stack.push(String.valueOf(num3));
                    continue;
                }
                if (s.equals("*")) {
                    int num3 = num1 * num2;
                    stack.push(String.valueOf(num3));
                    continue;
                }
                if (s.equals("/")) {
                    int num3 = num2 / num1;
                    stack.push(String.valueOf(num3));
                    continue;
                }
            } else {
                // �����ǰ�ַ����ǲ�����������ѹ��ջ��
                stack.push(s);
            }
        }
        // ���ջ��Ԫ�ؾ����沨�����ʽ��ֵ������ת��Ϊ����������
        return Integer.parseInt(stack.pop());
    }
}