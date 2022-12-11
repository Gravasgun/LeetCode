package leetcode.singleNumber;

import java.util.HashSet;
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
}

