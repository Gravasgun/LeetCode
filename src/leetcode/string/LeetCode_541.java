package leetcode.string;

public class LeetCode_541 {
    /**
     * 541.��ת�ַ���II
     * ����һ���ַ���s��һ������k�����ַ�����ͷ����ÿ������2k���ַ����ͷ�ת��2k�ַ��е�ǰk���ַ���
     * ���ʣ���ַ�����k������ʣ���ַ�ȫ����ת��
     * ���ʣ���ַ�С��2k�����ڻ����k������תǰk���ַ��������ַ�����ԭ����
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            // 1.ÿ��2k���ַ�,��ǰk���ַ����з�ת
            // 2.ʣ���ַ�С��2k�����ڻ����k������תǰk���ַ�
            if (i + k <= chars.length) {
                //����ҿ�
                reverse(chars, i, i + k - 1);
                //ֱ�ӽ�����һ��ѭ������ִ�е��������
                continue;
            }
            // 3.ʣ���ַ�����k������ʣ���ַ�ȫ����ת��
            reverse(chars, i, chars.length - 1);
        }
        return new String(chars);
    }

    public void reverse(char[] c, int i, int j) {
        for (; i < j; i++) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            j--;
        }
    }
}
