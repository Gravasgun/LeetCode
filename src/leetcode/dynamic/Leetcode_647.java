package leetcode.dynamic;

/**
 * 647.�����Ӵ�
 * ����һ���ַ��� s ������ͳ�Ʋ���������ַ����� �����Ӵ� ����Ŀ��
 * �����ַ��� �����Ŷ��͵�������һ�����ַ�����
 * ���ַ��� ���ַ����е��������ַ���ɵ�һ�����С�
 * ���в�ͬ��ʼλ�û����λ�õ��Ӵ�����ʹ������ͬ���ַ���ɣ�Ҳ�ᱻ������ͬ���Ӵ���
 */
public class Leetcode_647 {
    /**
     * ����һ������
     * �����ַ����л����Ӵ��ĸ���
     *
     * @param s �������ַ���
     * @return �����Ӵ��ĸ���
     */
    public int countSubstringsMethodOne(String s) {
        int length = s.length();
        int count = 0;
        // �����ַ����������Ӵ������ж��Ƿ��ǻ��Ĵ�
        // ��һ��forѭ��������ʼλ�� �ڶ���forѭ��������ֹλ��
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                // �����ǰ�Ӵ��ǻ��Ĵ������������һ
                if (isPalindromeSubstring(s.substring(i, j + 1))) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * �жϸ������ַ����Ƿ��ǻ��Ĵ�
     *
     * @param s �������ַ���
     * @return �Ƿ��ǻ��Ĵ�
     */
    public boolean isPalindromeSubstring(String s) {
        int left = 0;
        int right = s.length() - 1;
        // ���ַ��������˿�ʼ���м���������ж϶�Ӧ�ַ��Ƿ����
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * ����������̬�滮
     * @param s �������ַ���
     * @return �����Ӵ��ĸ���
     */
    public int countSubstringsMethodTwo(String s) {
        int result = 0;
        // dp[i][j]:��ʾ���䷶Χ[i,j]������ұգ����Ӵ��Ƿ��ǻ����Ӵ�������� dp[i][j]Ϊtrue������Ϊfalse
        boolean[][] dp = new boolean[s.length()][s.length()];
        // ���µ��� �����ұ���
        // ��Ϊ���ַ������ȴ���2ʱ����Ҫ�ж��м���ַ����Ƿ��ǻ����Ӵ�
        // �м��Ƿ��ǻ����Ӵ�����dp[i+1][j-1]
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                // ��ǰ�ַ����
                if (s.charAt(i) == s.charAt(j)) {
                    // ���Ӵ�����Ϊ1��2ʱ��һ���ǻ����Ӵ��������1
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        result++;
                    }
                    // ���Ӵ����ȴ���2ʱ���ж�ȥ�������ַ����Ӵ��Ƿ�Ϊ�����Ӵ�
                    else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }

}
