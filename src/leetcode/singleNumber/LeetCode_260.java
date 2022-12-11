package leetcode.singleNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetCode_260 {
    /**
     * 260.ֻ����һ�ε�����III
     * ��Ŀ����������һ����������nums������ǡ��������Ԫ��ֻ����һ�Σ���������Ԫ�ؾ��������Ρ��ҳ�ֻ����һ�ε�������Ԫ�ء�����԰�����˳�򷵻ش𰸡�
     *
     * @param nums
     * @return
     */
    //����һ����hashmap���������е�ֵ��Ϊkey,��������������г��ֵĴ�����Ϊvalue��
    public int[] singleNumberMethodOne(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] list = new int[2];
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

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        //����map��Ѱ��value=1��key
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() == 1) {
                list[index++] = entry.getKey();
            }
        }
        return list;
    }

    //��������λ���㣺^
    public int[] twoSingleNumberMethodTwo(int[] nums) {
        int num1 = 0;
        for (int num : nums) {
            num1 ^= num;
        }
        //num1=a^b����Ϊa��b��������ͬ���� -> num1������0(^����,��ͬΪ0) -> num1��ĳһλ��һ����1,˵��a��b����һλ�ϵ�ֵ��ͬ
        int rightOne = num1 & (~num1 + 1);//��ȡ��num1����������Ҳ��1
        int type1 = 0;//��������a����b
        int type2;//��������a����b
        for (int num : nums) {
            //��nums�е�����Ԫ�طֳ����࣬����һ��������ж����Ʊ�ʾ�ĵ�mλΪ0��������һ��������ж����Ʊ�ʾ�ĵ�mλΪ1����
            //��������һ��������nums�г������ε�Ԫ�أ���Ԫ�ص����γ��ֻᱻ������ͬһ����,�ٽ���һ���������,Ҳ�ᱻ������
            //��������һ��������nums��ֻ������һ�ε�Ԫ�أ���a,b ���ǻᱻ�����ڲ�ͬ���У��ٽ���һ��������㣬�ͻ�õ����е�һ������
            if ((num & rightOne) == 0) {
                type1 ^= num;
            }
            //type1ҪôΪaҪôΪb
        }
        //type2=a^b^a=b(type1=a�����) || type2=a^b^b=a(type1=b�����)
        type2 = num1 ^ type1;
        return new int[]{type1, type2};
    }
}
