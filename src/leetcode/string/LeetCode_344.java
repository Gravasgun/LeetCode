package leetcode.string;

import java.util.Stack;

public class LeetCode_344 {
    /**
     * 344.��ת�ַ���
     * ��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ�����s����ʽ������
     * ��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ��O(1)�Ķ���ռ�����һ���⡣
     *
     * @param s
     */

    //����һ��˫ָ��
    public void reverseStringMethodOne(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    //��������ջ
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();
        //��ջ
        for (char c : s) {
            stack.push(c);
        }
        //��ջ
        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }
}
