package leetcode.dynamic;

public class Leetcode_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        // ����dp���� �����i��0��j��1��strs������Ӽ��ĳ���Ϊdp[i][j]
        int[][] result = new int[m + 1][n + 1];
        // ������Ʒ
        for (String s : strs) {
            int zeroNum = 0;
            int oneNum = 0;
            // ͳ������
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            //�������� ����������ά�ȵ����� ��Ӧ����ά�ȵı���
            for (int i = result.length - 1; i >= zeroNum; i--) {
                for (int j = result[0].length - 1; j >= oneNum; j--) {
                    result[i][j] = Math.max(result[i][j], result[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return result[result.length - 1][result[0].length - 1];
    }
}
