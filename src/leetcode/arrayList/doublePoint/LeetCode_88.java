package leetcode.arrayList.doublePoint;

import java.util.Arrays;

public class LeetCode_88 {
    /**
     * 88.�ϲ�������������
     * �����������ǵݼ�˳�����е���������nums1��nums2��������������m��n���ֱ��ʾnums1��nums2�е�Ԫ����Ŀ��
     * ����ϲ�nums2��nums1�У�ʹ�ϲ��������ͬ�����ǵݼ�˳�����С�
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    //����һ��˫ָ��
    public void mergeMethodOne(int[] nums1, int m, int[] nums2, int n) {
        //nums1��ָ��
        int point1 = 0;
        //nums2��ָ��
        int point2 = 0;
        //������
        int[] result = new int[m + n];
        for (int i = 0; i < result.length; i++) {
            //��ֹpoint1Խ��(��һ�������Ԫ�ر������ʱ�������±���Ϊ������ԭ�򣬻����Խ������)
            if (point1 >= m) {
                result[i] = nums2[point2++];
                //��ֹ��point2Խ��(��һ�������Ԫ�ر������ʱ�������±���Ϊ������ԭ�򣬻����Խ������)
            } else if (point2 >= n) {
                result[i] = nums1[point1++];
                //�����һ�������Ԫ�رȵڶ��������Ԫ��С
            } else if (nums1[point1] < nums2[point2]) {
                //�ѵ�һ�������Ԫ�ظ�ֵ��������
                result[i] = nums1[point1++];
            } else {
                //�ѵڶ��������Ԫ�ظ�ֵ��������
                result[i] = nums2[point2++];
            }
        }

        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }
    }

    //���������ϲ�������
    public void mergeMethodTwo(int[] nums1, int m, int[] nums2, int n) {
        //nums2��ָ��
        int j = 0;
        //�ϲ�����������
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j++];
        }
        //�ϲ���ɣ�ֱ������
        Arrays.sort(nums1);
    }
}
