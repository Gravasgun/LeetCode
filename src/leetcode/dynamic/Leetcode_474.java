package leetcode.dynamic;

/**
 * 474.һ����
 * ����һ���������ַ������� strs ���������� m �� n
 * �����ҳ������� strs ������Ӽ��ĳ��ȣ����Ӽ��� ��� �� m �� 0 �� n �� 1
 * ��� x ������Ԫ��Ҳ�� y ��Ԫ�أ����� x �Ǽ��� y �� �Ӽ�
 */
public class Leetcode_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        // ����dp���� �����i��0��j��1��strs������Ӽ��ĳ���Ϊdp[i][j]
        int[][] result = new int[m + 1][n + 1];
        // �����ַ��������е�ÿ���ַ�����һ���ַ������൱��һ����Ʒ
        for (String s : strs) {
            // ��¼�ַ���������������൱������
            int zeroNum = 0;
            // ��¼�ַ�����һ���������൱������
            int oneNum = 0;
            // ͳ���ַ��������һ������
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            // ʹ�ö�̬�滮���������
            // m��n�൱����������
            // zeroNum��oneNum�൱��һ����Ʒ������ά�ȵ�����
            for (int j = m; j >= zeroNum; j--) {
                for (int k = n; k >= oneNum; k--) {
                    // ѡ��ǰ�ַ�����ѡ��ǰ�ַ�����ȡ�ϴ�ֵ
                    // result[j - zeroNum][k - oneNum] + 1��ʾ��ǰ�ַ����ĳ��ȼ���ʣ������Ϊ[j - zeroNum][k - oneNum]ʱ����󳤶�
                    result[j][k] = Math.max(result[j][k], result[j - zeroNum][k - oneNum] + 1);
                }
            }
        }
        // ���ؽ�������������½ǵ�Ԫ�أ������γɵ�����ַ�������
        return result[m][n];
    }
}
