package leetcode.tree;

/**
 * 106.�����������������й��������
 * ����������������inorder��postorder������inorder�Ƕ����������������postorder��ͬһ�����ĺ�����������㹹�첢������Ŷ�������
 */
public class Leetcode_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // ��������������Ϊ�գ��򷵻�null
        if (postorder.length == 0) {
            return null;
        }
        // ���ݺ���������������һ��Ԫ�ش������ڵ�
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        // �������������г���Ϊ1����ýڵ�ΪҶ�ӽڵ㣬���ظýڵ�
        if (postorder.length == 1) {
            return root;
        }
        // ͨ�������������ȷ�����ڵ������е�λ��
        int index = 0;
        for (; index < inorder.length; index++) {
            if (inorder[index] == rootValue) {
                break;
            }
        }
        // ��������������н�ԭ���зֳ�����������������������
        int[] leftInorderList = new int[index];
        for (int i = 0; i < index; i++) {
            leftInorderList[i] = inorder[i];
        }

        int[] rightInorderList = new int[inorder.length - index - 1];
        int rightInorderIndex = 0;
        for (int i = index + 1; i < inorder.length; i++) {
            rightInorderList[rightInorderIndex++] = inorder[i];
        }

        // ������������������������������У�������������зֳ�����������������������
        int[] leftPostorderList = new int[leftInorderList.length];
        for (int i = 0; i < leftPostorderList.length; i++) {
            leftPostorderList[i] = postorder[i];
        }

        int[] rightPostorderList = new int[rightInorderList.length];
        int rightPostOrderIndex = 0;
        for (int i = leftPostorderList.length; i < postorder.length - 1; i++) {
            rightPostorderList[rightPostOrderIndex++] = postorder[i];
        }
        // �ݹ�ع�����������������
        TreeNode leftNode = buildTree(leftInorderList, leftPostorderList);
        TreeNode rightNode = buildTree(rightInorderList, rightPostorderList);
        // �����������������ֱ���Ϊ���ڵ�����Һ���
        root.left = leftNode;
        root.right = rightNode;
        // ���ظ��ڵ�
        return root;
    }
}


