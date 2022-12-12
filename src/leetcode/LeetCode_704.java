package leetcode;

public class LeetCode_704 {
    /**
     * 704.���ֲ���
     * ����һ��n��Ԫ������ģ�������������nums��һ��Ŀ��ֵtarget��дһ����������nums�е�target�����Ŀ��ֵ���ڷ����±꣬���򷵻�-1��
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target < nums[middle]) {
                //target�������䣬����[left, middle - 1]
                right = middle - 1;
            } else if (target > nums[middle]) {
                //target�������䣬����[middle + 1, right]
                left = middle + 1;
            } else {
                //nums[middle] == target
                //�������ҵ�Ŀ��ֵ��ֱ�ӷ����±�
                return middle;
            }
        }
        //δ�ҵ�Ŀ��ֵ
        return -1;
    }
}
