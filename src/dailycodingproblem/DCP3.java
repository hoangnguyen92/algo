package dailycodingproblem;

public class DCP3 {
    /**
     * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
     * <p>
     * For example, given the following Node class
     * <p>
     * class Node:
     * def __init__(self, val, left=None, right=None):
     * self.val = val
     * self.left = left
     * self.right = right
     * The following test should pass:
     * <p>
     * node = Node('root', Node('left', Node('left.left')), Node('right'))
     * assert deserialize(serialize(node)).left.left.val == 'left.left'
     */

    class Node {
        Node right;
        Node left;
        int val;
    }

    public static void main(String[] args) {

    }

}
