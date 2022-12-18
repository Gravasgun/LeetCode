package leetcode.arrayList.binarySearch;

public class LeetCode_35 {
    /**
     * 35.��������λ��
     * ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
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
        //ִ�е����˵�������в�����target���ֵ������right��leftС1���൱��[right,left]��nums[right]<target<nums[left],��ʱ����right+1����left������
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int num = searchInsert(nums, 7);
        System.out.println(num);
    }
}
