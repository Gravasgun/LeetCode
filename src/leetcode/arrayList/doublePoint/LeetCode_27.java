package leetcode.arrayList.doublePoint;

public class LeetCode_27 {
    /**
     * 27.�Ƴ�Ԫ��
     * ����һ������ nums��һ��ֵval������Ҫԭ���Ƴ�������ֵ����val��Ԫ�أ��������Ƴ���������³��ȡ�
     * ��Ҫʹ�ö��������ռ䣬������ʹ��O(1)����ռ䲢ԭ���޸��������顣
     *
     * @param nums
     * @param val
     * @return
     */
    //˫ָ��
    public int removeElementMethodOne(int[] nums, int val) {
        //��ָ�룬�����Ҹ��������Ԫ��
        int slow = 0;
        //��ָ�룬Ѱ�Ҳ�����Ŀ��Ԫ�ص�Ԫ��
        for (int fast = 0; fast < nums.length; fast++) {
            //����ָ����ָ����������val��ʱ��(�ҵ���)����fastָ����ָ��ֵ��ֵ��slowָ�루����slowָ���ֵ��
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    //�����ⷨ��
    public int removeElementMethodTwo(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            //������Ҫ�Ƴ���Ԫ�أ��ͽ����鼯����ǰ�ƶ�һλ
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                //��Ϊ�±�i�Ժ����ֵ����ǰ�ƶ���һλ������iҲ��ǰ�ƶ�һλ
                i--;
                //��ʱ����Ĵ�С-1
                length--;
            }
        }
        return length;
    }
}
