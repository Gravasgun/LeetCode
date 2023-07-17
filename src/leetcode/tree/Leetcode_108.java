package leetcode.tree;

public class Leetcode_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildSearchTree(nums, 0, nums.length - 1);
    }

    /**
     * �ݹ鹹������������
     *
     * @param nums  ��������
     * @param left  ��ǰ���������ʼ����
     * @param right ��ǰ������Ľ�������
     * @return �����õ��Ķ����������ĸ��ڵ�
     */
    private TreeNode buildSearchTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildSearchTree(nums, left, mid - 1);
        root.right = buildSearchTree(nums, mid + 1, right);
        return root;
    }
}
