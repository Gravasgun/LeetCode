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
    static class Point { // ����һ����ά��������
        int x;
        int y;

        Point(int x, int y) { // ���캯�������ڳ�ʼ���������
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // ��ȡ��׼�����Scanner����
        int n = scanner.nextInt(); // ���˵�����
        int a = scanner.nextInt(); // ����֮�����ĺ������
        int b = scanner.nextInt(); // ����֮�������������
        List<Point> points = new ArrayList<>(); // ���ڴ洢���˵�������б�
        for (int i = 0; i < n; i++) { // ѭ����ȡÿ�����˵����겢��ӵ��б���
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }
        // �Ե��˰��պ�������������
        Collections.sort(points, (p1, p2) -> p1.x - p2.x);
        int maxCount = 0; // ��¼����������
        for (int i = 0; i < n; i++) { // ѭ������ÿ������
            Point p1 = points.get(i); // ��ǰ����
            int count = 1; // ������ǰ�����������ڵ�����
            for (int j = i + 1; j < n; j++) { // �ӵ�ǰ���˵���һ�����˿�ʼ����
                Point p2 = points.get(j);
                if (p2.x - p1.x > a) { // �����ǰ��������һ������֮��ĺ�������Ѿ�����a������ѭ��
                    break;
                }
                if (Math.abs(p2.y - p1.y) <= b) { // �����ǰ��������һ������֮����������С�ڵ���b����������1
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count); // ��������������
        }
        System.out.println(maxCount); // �������������
    }
}
