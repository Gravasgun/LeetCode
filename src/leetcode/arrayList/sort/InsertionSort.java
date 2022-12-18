package leetcode.arrayList.sort;

public class InsertionSort {
    public static int[] insert_sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //����д�Ļ���j�Ͳ���ֻ�в���j=0��ʱ��Ž����ˣ����ٵڶ���ѭ���Ĵ�����
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                swap(nums, j, j + 1);
            }
        }
        return nums;
    }


//    public static int[] insert_sort(int[] nums) {
//        for (int i = 1; i < nums.length; i++) {
//            //j��Ϊ0��ʱ�򣬵ڶ���forѭ���Ž���
//            for (int j = i - 1; j >= 0; j--) {
//                if (nums[j] > nums[j + 1]) {
//                    swap(nums, j, j + 1);
//                }
//            }
//        }
//        return nums;
//    }

//    public static int[] insert_sort(int[] nums) {
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (nums[j] > nums[i]) {
//                    //����i�����仯�ˣ����µڶ���ѭ������ʱ,i��ֵ���ܻ����֮ǰ�ظ�����ֵ����ôj��ֵҲ����ŷ����仯����j��ֵҲ���ظ�����ֵ
//                    //��ʱ������ѭ�����ᷢ���ظ�
//                    swap(nums, j, i--);
//                }
//            }
//        }
//        return nums;
//    }

    public static void swap(int[] arr, int num1, int num2) {
        arr[num1] = arr[num1] ^ arr[num2];
        arr[num2] = arr[num1] ^ arr[num2];
        arr[num1] = arr[num1] ^ arr[num2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 6, 8, 7, 55, 99, 44, 63, 78};
        int[] numArr = insert_sort(nums);
        for (int num : numArr) {
            System.out.print(num + " ");
        }
    }
}

