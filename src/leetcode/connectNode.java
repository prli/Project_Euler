package leetcode;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class connectNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    //no parent -> node.next = null
    //if parent ->
    //  if parent.left == node then node.next = parent.right
    //  else node.next = parent.next.left

    //node.next =
    public Node connect(Node node) {
        if (node != null) {
            return new Node(node.val, connect(node.left, node), connect(node.right, node), null);
        } else {
            return null;
        }
    }

    //node.next =
    public Node connect(Node node, Node parent) {
        if (node != null) {
            if (parent.left == node) {
                node.next = parent.right;
            } else {
                if (parent.next != null) {
                    node.next = parent.next.left;
                }
            }
            return new Node(node.val, connect(node.left, node), connect(node.right, node), node.next);
        } else {
            return node;
        }

    }

    public static void main(String[] args) {


    }
}
