package leetcode.arrayList.singleNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Offer_004 {
    /**
     * ��ָOffer004
     * ��Ŀ������һ����������nums����ĳ��Ԫ�ؽ�����һ���⣬����ÿ��Ԫ�ض�ǡ�������Ρ������ҳ��������Ǹ�ֻ������һ�ε�Ԫ�ء�
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        /**
         * ˼·����hashmap���������е�ֵ��Ϊkey,������ֳ��ֵĴ�����Ϊvalue��
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //�������е�Ԫ��һһ����map�����Ԫ����Ϊkey,���ֵĴ�����Ϊvalue��
            //map.getOrDefault(num, 0) + 1)���������ʾ��
            //���map�д���keyΪnum��value,��ô��������ķ���ֵ����value����������ڣ��Ͱѵڶ����������ó�value,����ֵҲ���ó�value��
            //���磺��һ����key=num��Ԫ�أ��϶�������,��ôĬ��ֵ����0
            //�ڶ�����key=value��Ԫ�أ������ˣ�value=1
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                int count = map.get(num);
                map.put(num, ++count);
            }
            //map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        //����map��Ѱ��value=1��key
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }
}
