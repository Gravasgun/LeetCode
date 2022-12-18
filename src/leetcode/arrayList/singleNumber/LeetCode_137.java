package leetcode.arrayList.singleNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetCode_137 {
    /**
     * 137.ֻ����һ�ε�����II
     * ��Ŀ����������һ����������nums����ĳ��Ԫ�ؽ�����һ���⣬����ÿ��Ԫ�ض�ǡ�������Ρ������ҳ��������Ǹ�ֻ������һ�ε�Ԫ�ء�
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        /**
         * ˼·����hashmap���������е�ֵ��Ϊkey,��������������г��ֵĴ�����Ϊvalue��
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //���map���Ҳ����������,�Ͱ�������ַŽ�map,����value(���ֵĴ���)Ϊ1
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                //map���ҵ���������֣�˵������������ظ��ģ���Ҫ��value(���ֵĴ���)��һ���ٷ���map����Ϊmap�е�key�ظ��ˣ�����value��ֵ�ᱻ�滻��
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
