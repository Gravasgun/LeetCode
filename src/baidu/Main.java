package baidu;

import java.util.Scanner;

/**
 * ��Ŀ������
 * Ѱ�Ҿ����е�������λ�õ����·�����ȣ�ÿ�ƶ�һ��λ�õĳ���Ϊ 1
 *
 * ����������
 * ��һ�������������� x �� y ,�ֱ������������������
 * �ڶ��������������� m �� n ,�ֱ����ָ��λ�õĺ������������
 *
 * ���������
 * ���һ������ t ,������ָ��λ�õ����·������
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // ����������������
        int x = input.nextInt();
        int y = input.nextInt();
        // �߽��ж�
        if (x <= 0 || y <= 0) {
            System.out.println(0);
            return;
        }
        // result[i][j]:����(i,j)��������·��Ϊresult[i][j]
        int[][] result = new int[x][y];
        int targetX = input.nextInt();
        int targetY = input.nextInt();
        // �߽��ж�
        if (targetX <= 0 || targetX >= x || targetY <= 0 || targetY >= y) {
            System.out.println(0);
        } else {
            // ���ö�̬�滮����
            findMinPath(result);
            // �������ָ����������·������
            System.out.println(result[targetX][targetY]);
        }
    }

    private static void findMinPath(int[][] result) {
        if (result == null) {
            return;
        }
        // ��ʼ��dp����
        // ��һ�е����·��ֻ�ܴ����Ƶ�
        for (int i = 1; i < result[0].length; i++) {
            result[0][i] = i;
        }
        // ��һ�е����·��ֻ���Ǵ��Ϸ��Ƶ�
        for (int i = 1; i < result.length; i++) {
            result[i][0] = i;
        }
        // ������ ���ϵ������dp����
        // ��һ�к͵�һ���Ѿ���ɳ�ʼ�� ���Դӵڶ��к͵ڶ��п�ʼ
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // ����һ�к͵�һ�����������һ��λ��ֻ�ܴ� �������� �ĸ����򵽴�
                // Ҫ����̵�·������ ���ҷ����·����ﶼ��������̵�
                // ����ֻ�ÿ��Ǵ��󷽻����Ϸ������������·�� ѡ���������Сֵ+1
                result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + 1;
            }
        }
    }
}