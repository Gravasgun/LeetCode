package leetcode.arrayList.binarySearch;

public class LeetCode_34 {
    /**
     * 34.�����������в���Ԫ�صĵ�һ�������һ��λ��
     * ����һ�����շǵݼ�˳�����е���������nums����һ��Ŀ��ֵtarget�������ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
     * ��������в�����Ŀ��ֵ target������[-1, -1]��
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        //�����������Ƿ�����������
        int index = search(nums, target);
        //���index=-1��˵�������в�����������֣���ôֱ�ӷ���[-1, -1]
        if (index == -1) {
            return new int[]{-1, -1};
        }
        //ִ�е����˵�������д���������֣���ʱ��ҪѰ����߽���ұ߽�
        int left = index;
        int right = index;
        //��left��ߵ��������ң�����߽�
        //��ֹ����Խ�硣�߼���·����������˳���ܻ�
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }
        //��right�ұߵ������ң����ұ߽�
        //��ֹ����Խ�硣�߼���·����������˳���ܻ�
        while (right + 1 < nums.length && nums[right + 1] == target) {
            right++;
        }
        return new int[]{left, right};
    }

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
