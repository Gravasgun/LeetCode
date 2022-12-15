package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_26 {
    /**
     *26.ɾ�����������е��ظ���
     * ����һ���������е�����nums,����ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹÿ��Ԫ��ֻ����һ��
     * ����ɾ����������³��ȡ�Ԫ�ص����˳��Ӧ�ñ���һ�¡�
     * @param nums
     * @return
     */
    public int removeDuplicatesMethodOne(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int length = 0;
        for (int num : nums) {
            if (set.add(num)) {
                nums[length++] = num;
            }
        }
        return length;
    }

    public int removeDuplicatesMethodTwo(int[] nums) {
        //��ָ�룬�����Ҹ��������Ԫ��
        int slow = 0;
        //��ָ�룬Ѱ�Ҳ��ظ���Ԫ��
        for (int fast=1;fast< nums.length;fast++){
            //ֻҪ�ҵ�������ָ�벻�ظ���Ԫ�أ��͸�����ָ���һλԪ�ص�ֵ����Ϊ����Ҫ����һ�����ظ���Ԫ�أ����ԴӺ�һλ��ʼ
            if (nums[slow]!=nums[fast]){
                nums[++slow]=nums[fast];
            }
        }
        return ++slow;
    }

    @Test
    public void test(){
        int [] nums=new int[]{0,0,1,1,1,2,2,3,3,4};
        int count = removeDuplicatesMethodTwo(nums);
        System.out.println(count);
    }
}
