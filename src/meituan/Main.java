package meituan;

import java.util.*;

/**
 * ��Ŀ������
 * С������һ����Ϸ������Ϸ��Ŀ���Ǿ�����ץ�����ˡ�
 * ���˵�λ�ñ�һ����ά����(x,y)��������С����һ��ȫ�����ܣ��ü�����һ���Խ����ɵ���һ���Բ���
 * ����ĵ���֮��ĺ����������ֵ���ܴ���A�������������ֵ���ܴ���B��
 * ���ڸ������е��˵����꣬��������Ǽ���С��һ���������ʹ�ü��ܲ�����ٵ��ˡ�
 * ����������
 * ��һ����������N,A,B����ʾ����N�����ˣ�С����ȫ�����ܲ���A�Ͳ���B����������N�У�ÿ����������X,Y������һ���������ڵ����ꡣ
 * 1<=N<=500,1<=A,B<=1000,1<=x,y<=1000��
 * ���������
 * һ�У�һ��������ʾС��ʹ�ü��ܵ��ο��Բ�������������
 */
class Main {
    // ����һ����ά��������
    static class Point {
        int x;
        int y;
        // ���캯�������ڳ�ʼ���������
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ���˵�����
        int n = scanner.nextInt();
        // ����֮�����ĺ������
        int a = scanner.nextInt();
        // ����֮�������������
        int b = scanner.nextInt();
        // ���ڴ洢���˵�������б�
        List<Point> points = new ArrayList<>();
        // ѭ����ȡÿ�����˵����겢��ӵ��б���
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }

        // �Ե��˰��պ�������������
        Collections.sort(points, (p1, p2) -> p1.x - p2.x);
        // ��¼����������
        int maxCount = 0;
        // ѭ������ÿ������
        for (int i = 0; i < n; i++) {
            // ��ǰ����
            Point p1 = points.get(i);
            // ������ǰ�����������ڵ�����
            int count = 1;
            // �ӵ�ǰ���˵���һ�����˿�ʼ����
            for (int j = i + 1; j < n; j++) {
                Point p2 = points.get(j);
                // �����ǰ��������һ������֮��ĺ�������Ѿ�����a������ѭ��
                if (Math.abs(p2.x - p1.x) > a) {
                    break;
                }
                // �����ǰ��������һ������֮����������С�ڵ���b����������1
                if (Math.abs(p2.y - p1.y) <= b) {
                    count++;
                }
            }
            // ��������������
            maxCount = Math.max(maxCount, count);
        }
        // �������������
        System.out.println(maxCount);
    }
}
