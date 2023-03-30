package leetcode.string;

public class LeetCode_459 {
    /**
     * 459. �ظ������ַ���
     * ����һ���ǿյ��ַ��� s ������Ƿ����ͨ��������һ���Ӵ��ظ���ι��ɡ�
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length(); // �ַ�������
        // ���ַ������м�λ�ÿ�ʼ������С�Ӵ��ĳ���
        for (int i = n / 2; i >= 1; i--) {
            // ����ܹ�����������˵�����ܴ����ظ��Ӵ�
            if (n % i == 0) {
                // �Ӵ�������
                int m = n / i;
                // ȡ���Ӵ�
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                // ���Ӵ��ظ� m �Σ��õ�һ���µ��ַ���
                for (int j = 0; j < m; j++) {
                    sb.append(sub);
                }
                // ������ַ�����ԭ�ַ�����ͬ����˵��ԭ�ַ�������������Ӵ��ظ���ι���
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false; // �޷����Ӵ��ظ�����
    }
}
