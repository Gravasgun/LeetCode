package leetcode.arrayList.singleNumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Offer_003 {
    /**
     * ��ָOffer003.�������ظ�������
     * �ҳ��������ظ������֡�
     * ��һ������Ϊn������nums����������ֶ���0��n-1�ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡�
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberMethodOne(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            //���set�в������������ˣ�˵����set���Ѿ�������
            //���ʱ��ֱ�ӷ���������ּ���
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    //��������hashMap
    public int findRepeatNumberMethodTwo(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                int count = map.get(num);
                map.put(num, ++count);
            }
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() != 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
