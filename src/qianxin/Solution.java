package qianxin;

import java.util.*;


public class Solution {
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     *
     * @param planks int����һά���� 
     * @return bool������
     */
    public boolean CheckSquare (int[] planks) {
        // write code here
        int sum= Arrays.stream(planks).sum();
        if (sum%4==0){
            return true;
        }
        return false;
    }
}