package leetcode.hashTable;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_202 {
    /**
     * 202.������
     * ��дһ���㷨���ж�һ����n�ǲ��ǿ�������
     *��������������Ϊ��
     *  ����һ����������ÿһ�ν������滻Ϊ��ÿ��λ���ϵ����ֵ�ƽ���͡�
     *  Ȼ���ظ��������ֱ���������Ϊ1��Ҳ����������ѭ����ʼ�ձ䲻��1��
     *  ���������̽��Ϊ1����ô��������ǿ�������
     *  ���n�ǿ������ͷ���true,�����򷵻�false��
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        //�����ж��Ƿ��������ѭ��
        Set<Integer> set = new HashSet<>();
        //��n=1���߳�������ѭ��ʱ������whileѭ��
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            //ȡ�����������һλ
            int num = n % 10;
            //���������
            sum += num * num;
            //���������һλ���֣��ٽ���ѭ��
            n = n / 10;
        }
        return sum;
    }
}
