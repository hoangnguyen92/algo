package problemsolver;

public class BinarySearTree {
    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;
        int balance;
        int height;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node n = buildBinaryTree(new int[]{1, 2, 3, 4, 5});
//        Node n4 = new Node(4);
//        Node n1 = new Node(1);
//        Node n3 = new Node(3);
//        Node n2 = new Node(2);
//
//        n4.left = n1;
//        n1.parent = n4;
//        n1.right = n3;
//        n3.parent = n1;
//        n3.left = n2;
//        n2.parent = n3;


        balanceTheTree(n);

        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", n);
        System.out.println(sb.toString());
    }

    private static void balanceTheTree(Node n) {
        if (n == null) {
            return;
        }

        balanceTheTree(n.left);
        balanceTheTree(n.right);

        int leftHeight = n.left == null ? 0 : n.left.height;
        int rightHeight = n.right == null ? 0 : n.right.height;
        n.balance = leftHeight - rightHeight;
        n.height = Math.max(leftHeight, rightHeight) + 1;

        if (Math.abs(n.balance) > 1) {
            System.out.println("Rotate node: " + n.value);

            if (n.balance == -2 && n.right.balance == 1) {
                rotateRight(n.right);
                rotateLeft(n);
            }

            if (n.balance == 2 && n.left.balance == -1) {
                rotateLeft(n.left);
                rotateRight(n);
            }

            if (n.balance == -2 && n.right.balance == -1) {
                rotateLeft(n);
            }

            if (n.balance == 2 && n.right.balance == 1) {
                rotateRight(n);
            }
        }

    }

    private static void rotateLeft(Node n) {
        Node right = n.right;
        Node left = n.right == null ? null : n.right.left;

        right.left = n;
        n.right = left;

        if (n.parent != null) {
            n.parent.left = right;
        }

        balanceTheTree(n);
    }

    private static void rotateRight(Node n) {
        Node right = n.left == null ? null : n.left.right;
        Node left = n.left;

        left.right = n;
        n.left = right;

        if (n.parent != null) {
            n.parent.right = left;
        }

        balanceTheTree(n);
    }

    private static Node buildBinaryTree(int[] array) {
        if (array.length < 1)
            return null;
        Node parent = new Node(array[0]);
        parent.parent = null;

        for (int i = 1; i < array.length; i++) {
            addElementToTree(parent, array[i]);
        }

        return parent;
    }

    private static void addElementToTree(Node root, int value) {
        if (root.value == value)
            return;

        if (root.value < value && root.right == null) {
            root.right = new Node(value);
            root.right.parent = root;
        } else if (root.value < value) {
            addElementToTree(root.right, value);
        } else if (root.value > value && root.left == null) {
            root.left = new Node(value);
            root.left.parent = root;
        } else if (root.value > value) {
            addElementToTree(root.left, value);
        }
    }

    public static void traversePreOrder(StringBuilder sb, String padding, String pointer, Node node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.value);
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = (node.right != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.left);
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.right);
        }
    }
}
