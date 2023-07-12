package leetcode.tree;

import java.util.List;

public class Leetcode_559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        List<Node> children = root.children;
        if (!children.isEmpty()) {
            for (Node node : children) {
                max = Math.max(maxDepth(node), max);
            }
        }
        return max + 1;
    }
}
