package leetcode.string;

public class LeetCode_28 {
    /**
     * 28.�ҳ��ַ����е�һ��ƥ������±�
     * ���������ַ��� haystack �� needle �������� haystack �ַ������ҳ� needle �ַ����ĵ�һ��ƥ������±꣨�±�� 0 ��ʼ����
     * ��� needle ���� haystack ��һ���֣��򷵻�  -1 ��
     *
     * @param haystack Ҫ�������ַ���
     * @param needle Ҫƥ����ַ���
     * @return ƥ������±꣨����ҵ�����-1�����δ�ҵ���
     */
    public int strStr(String haystack, String needle) {
        // ��ȡhaystack��needle�ĳ���
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        // �߽����������needleΪ���ַ������򷵻�0
        if (needleLen == 0) {
            return 0;
        }

        // ���haystack�ĳ���С��needle�ĳ��ȣ��򲻿���ƥ��ɹ�
        if (haystackLen < needleLen) {
            return -1;
        }

        // ����haystack�е�ÿ���ַ���ֱ��ʣ�µ��ַ���������ƥ��needle
        // haystackLen - i >= needleLen ���ܱ�֤ʣ�µ��ַ���ƥ��needle
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            // ��haystack��Ѱ��needle��ƥ����
            boolean found = true;
            // ����needle�е�ÿ���ַ���������haystack�ж�Ӧ���ַ��Ƚ�
            for (int j = 0; j < needleLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    // �����һ���ַ���ƥ�䣬��˵�����λ�ò���ƥ����
                    found = false;
                    break;
                }
            }
            if (found) {
                // ����ҵ���ƥ����򷵻����±�
                return i;
            }
        }
        // ���ѭ��������û���ҵ�ƥ����򷵻�-1
        return -1;
    }
}