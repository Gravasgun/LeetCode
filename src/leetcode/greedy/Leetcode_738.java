package leetcode.greedy;

/**
 * 738.��������������
 * ���ҽ���ÿ������λ���ϵ����� x �� y ���� x <= y ʱ�����ǳ���������ǵ��������ġ�
 * ����һ������ n ������С�ڻ���� n ��������֣������ֳʵ���������
 */
public class Leetcode_738 {
    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);  // ������ת��Ϊ�ַ���
        char[] chars = str.toCharArray();  // ���ַ���ת��Ϊ�ַ�����
        int start = str.length();  // ��¼��Ҫ�޸ĵ���ʼλ�ã�Ĭ��Ϊ�ַ����ĳ���
        // ������������ַ�����
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i - 1] > chars[i]) {
                chars[i - 1]--;  // ����ǰλ��ǰһλ���ּ�1
                start = i;  // ��¼��1����λ�õ�����
            }
        }
        // ��������start��ʼ���������ֶ��޸�Ϊ9�������㵥��������Ҫ��
        for (int i = start; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));  // ���ַ�����ת��Ϊ����������
    }
}