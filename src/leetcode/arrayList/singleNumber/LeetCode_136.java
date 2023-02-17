package leetcode.arrayList.singleNumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_136 {
    /**
     * 136.ֻ����һ�ε�����
     * ��Ŀ����������һ���ǿ���������nums ������ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
     *
     * @param nums
     * @return
     */
    //����һ:hashSet�����ַ���ֻ�������ظ������ֳ�����ż����,ֻ���ҳ� ���������ε�����
    public int singleNumberMethodOne(int[] nums) {
        //˼·����hashset�����У����һ�������ܱ���ӽ����ϣ�˵���������set�������Ѿ������ˣ����ʱ��ֻҪɾ�������е�������֣��Ϳ��Եõ������г�����������������
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return (int) set.toArray()[0];
    }

    //������:^��������㣬���ַ���ֻ�������ظ������ֳ�����ż����
    public int singleNumberMethodTwo(int[] nums) {
        //˼·��ʹ��λ����^���������е�ÿһ��Ԫ�ض���0��^���㡣
        //���һ�����ֳ���ż���Σ����������0����������㣬��ô���Ϊ0��
        //���һ�����ֳ��������Σ����������0����������㣬��ô���Ϊ���������
        //�ٽ�Ͻ�����,���԰�һ����������������������������,���磺0^(a^a^a^a)^(b^b^b)=(a^a^a^a)^(b^b^b)=b��
        //4��a���������Ϊ0��3��b���������Ϊb����󻯼�Ϊ:a^b=0^b=b��
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return temp;
    }

    //���������뷨һ��ͬ��˼·��ֻ���������˲�ͬ��api
    public int singleNumberMethodThree(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return (int) set.toArray()[0];
    }

    //�����ģ�HashMap��������Ϊmap��key�����ֳ��ֵĴ�����Ϊmap��value��������map���ҳ�����Ϊһ�����֡�
    public int singleNumberMethodFour(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                int count = map.get(num);
                map.put(num, ++count);
            }
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

