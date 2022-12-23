package leetcode.string;

public class LeetCode_344 {
    /**
     * 344.��ת�ַ���
     * ��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ�����s����ʽ������
     * ��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ��O(1)�Ķ���ռ�����һ���⡣
     *
     * @param s
     */

    //����һ��˫ָ��
    public void reverseString(char[] s) {
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

}
