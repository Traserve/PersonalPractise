package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 二叉排序树相关操作
 *
 * @author Cao.Zhuang
 * @date 2019/11/11 11:52
 */

public class TreeOperation {

    private static int[] array = {8, 3, 15, 1, 4, 9, 20};
    private static List<TreeNode> nodeList = null;

    public static void main(String[] args) {
        createBinTree();
        TreeNode root = nodeList.get(0);
        TreeNode a = new TreeNode(12);
        root.right.left.right = a;
        TreeNode b = new TreeNode(18);
        root.right.right.left = b;
        TreeNode c = new TreeNode(19);
        b.right = c;
        System.out.println("先序遍历：");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraverse(root);
        System.out.println();

        TreeNode node = deleteNode(root, 15);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;
        //找到要删除的节点
        while (current != null) {
            if (current.data > key) {
                //当前值比查找值大，搜索左子树
                parent = current;
                isLeftChild = true;
                current = current.left;
            } else if (current.data < key) {
                //当前值比查找值小，搜索右子树
                parent = current;
                isLeftChild = false;
                current = current.right;
            } else {
                break;
            }
        }
        //删除节点无子节点，直接删除
        if (current.left == null && current.right == null) {
            if (current == root) {
                return null;
            }
            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        //删除节点只有一个子节点
        if (current.left == null && current.right != null) {
            if (current == root) {
                root = root.right;
            }
            if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        if (current.left != null && current.right == null) {
            if (current == root) {
                root = root.left;
            }
            if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        //删除节点有两个及两个以上子节点（删除后要进行调整太过麻烦，可以设置一个标志位）
        TreeNode successorNode = getSuccessor(current);
        if (root == current) {
            root = successorNode;
        } else {
            if (isLeftChild) {
                parent.left = successorNode;
            } else {
                parent.right = successorNode;
            }
            successorNode.left = current.left;
        }
        return root;
    }

    /**
     * 获取删除节点的后继节点 ①、后继节点是删除节点的右子节点，只需要将后继节点表示的子树移到被删除节点的位置即可 ②、后继节点是删除节点的右子节点的左子节点
     */
    public static TreeNode getSuccessor(TreeNode delNode) {
        TreeNode successorParent = delNode;
        TreeNode successor = delNode;
        TreeNode current = delNode.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        //后继节点不是删除节点的右子节点，将后继节点替换删除节点
        if (successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }

        return successor;
    }

    public static TreeNode insertNode(TreeNode root, int data) {
        TreeNode current = root;
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            return newNode;
        }
        TreeNode parentNode;
        while (current != null) {
            parentNode = current;
            if (current.data > data) {
                current = current.left;
                if (current == null) {
                    parentNode.left = newNode;
                }
            } else if (current.data < data) {
                current = current.right;
                if (current == null) {
                    parentNode.right = newNode;
                }
            }
        }
        return root;
    }

    public static TreeNode findNode(TreeNode root, int key) {
        TreeNode current = root;
        while (current != null) {
            if (current.data > key) {
                //当前值比查找值大，搜索左子树
                current = current.left;
            } else if (current.data < key) {
                //当前值比查找值小，搜索右子树
                current = current.right;
            } else {
                return current;
            }
        }
        //遍历完整个树没找到，返回null
        return null;
    }

    /**
     * 先序遍历
     */
    public static void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 中序遍历
     */
    public static void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left);
        System.out.print(node.data + " ");
        inOrderTraverse(node.right);
    }

    /**
     * 后序遍历
     */
    public static void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * 先序遍历二叉树（非递归）
     */
    public static void preOrderTraverseNoRecursion(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode currentNode = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            System.out.print(currentNode.data + " ");
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }

    /**
     * 中序遍历二叉树（非递归）
     */
    public static void inOrderTraverseNoRecursion(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            // 一直循环到二叉排序树最左端的叶子结点（currentNode是null）
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.right;
        }
    }

    /**
     * 后序遍历二叉树（非递归）
     */
    public static void postOrderTraverseNoRecursion(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode currentNode = root;
        TreeNode rightNode = null;
        while (currentNode != null || !stack.isEmpty()) {
            // 一直循环到二叉排序树最左端的叶子结点（currentNode是null）
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            // 当前结点没有右结点或上一个结点（已经输出的结点）是当前结点的右结点，则输出当前结点
            while (currentNode.right == null || currentNode.right == rightNode) {
                System.out.print(currentNode.data + " ");
                rightNode = currentNode;
                if (stack.isEmpty()) {
                    return; //root以输出，则遍历结束
                }
                currentNode = stack.pop();
            }
            //还有右结点没有遍历
            stack.push(currentNode);
            currentNode = currentNode.right;
        }
    }

    /**
     * 广度优先遍历二叉树，又称层次遍历二叉树
     */
    public static void breadthFirstTraverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode currentNode = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            System.out.print(currentNode.data + " ");
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
    }

    public static void createBinTree() {
        nodeList = new LinkedList<TreeNode>();
        // 将一个数组的值依次转换为TreeNode节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new TreeNode(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).right = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }
}
