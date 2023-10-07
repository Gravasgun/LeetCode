package qianxin;

import java.io.*;
import java.util.*;


public class Solution2 {
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     * <p>
     * ��ȡ���������Ʋ�Ʒ���
     *
     * @param products Point��ArrayList ��Ʋ�Ʒ�����б�
     * @param months   int���� ��Ͷ���·�
     * @return Point��ArrayList
     */
    public ArrayList<Point> maxIncomeProducts(ArrayList<Point> products, int months) {
        // write code here
        //BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("a.xt"));
        ArrayList<Point> list = new ArrayList<>();
        int[] values = new int[products.size()];
        int[] weight = new int[products.size()];
        //��ʼ��
        for (int i = 0; i < products.size(); i++) {
            weight[i] = products.get(i).x;
            values[i] = products.get(i).y;
        }
        int[] result = new int[months + 1];
        //���dp����
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j < result.length; j++) {
                int temp = result[j];
                result[j] = Math.max(result[j], result[j - weight[i]] + values[i]);
                if (result[j] != temp) {
                    list.add(new Point(weight[i], values[i]));
                }
            }
        }
        return list;
    }
}