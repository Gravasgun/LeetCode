package leetcode.singleNumber;

import java.util.HashSet;
import java.util.Set;

public class Offer_003 {
    /**
     * ��ָOffer003.�������ظ�������
     * �ҳ��������ظ������֡�
     * ��һ������Ϊn������nums����������ֶ���0��n-1�ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡�
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num:nums){
            //���set�в������������ˣ�˵����set���Ѿ�������
            //���ʱ��ֱ�ӷ���������ּ���
            if (!set.add(num)){
                return num;
            }
        }
        return -1;
    }
}
