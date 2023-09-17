import lombok.*;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tree {

    private int value;
    private Tree left;
    private Tree right;

    private Tree parent;

    public static void main(String[] args) {
//        Tree tree = new Tree(20,new Tree(7, new Tree(4,null,new Tree(6,null,null)),new Tree(9,null,null)),
//                new Tree(35,new Tree(31,new Tree(28,null,null),null),
//                        new Tree(40,new Tree(38,null,null), new Tree(52,null,null))));
//
//        System.out.println(sumWide(tree));
    }
    public static int sumDeep(Tree root) {
        Stack<Tree> stack = new Stack<>();
        stack.push(root);

        int summ = 0;

        while (!stack.isEmpty()) {
            Tree node = stack.pop();

            System.out.println(node.value);

            summ = summ + node.value;

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return summ;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public static int sumWide(Tree root) {
        Queue<Tree> stack = new ArrayDeque<>();
        stack.add(root);

        int summ = 0;

        while (!stack.isEmpty()) {
            Tree node = stack.remove();

            System.out.println(node.value);

            summ = summ + node.value;

            if (node.left != null) {
                stack.add(node.left);
            }

            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return summ;
    }
    public Tree get(int value) {
        if(value == this.value) {
            return this;
        } else if (value < this.value && this.left != null) {
            return this.left.get(value);
        } else if (value > this.value && this.right != null) {
            return this.right.get(value);
        }
        return null;
    }
    public boolean deleteNode(int value) {
        Tree current = get(value);
        if (current == null) {
            return false;
        }
        Tree p = current.parent;
        if (current.left == null && current.right == null) {
            if (p.left == current) {
                p.left = null;
            }
            if (p.right == current) {
                p.right = null;
            }
            return true;
        } else if (current.left == null || current.right == null) {
            if (current.left == null) {
                if (p.left == current) {
                    p.left = current.right;
                } else {
                    p.right = current.right;
                    current.right.parent = p;
                }
            } else {
                if (p.left == current) {
                    p.left = current.left;
                } else {
                    p.right = current.left;
                    current.left.parent = p;
                }
            }
        } else {
            Tree successor = getSuccessor(current);
            if (successor.parent.left == successor) {
                successor.parent.left = successor.right;
                if (successor.right != null) {
                    successor.right.parent = successor.parent;
                }
            }else {
                successor.parent.right = successor.right;
                if (successor.right != null){
                    successor.right.parent = successor.parent;
                }
            }
        }
        return true;
    }
    public Tree getSuccessor(Tree delete) {
        Tree parentSuccessor = delete;
        Tree successor = delete;
        Tree current = successor.right;
        while (current != null) {
            parentSuccessor = successor;
            successor = current;
            current = current.left;
        }
        if (successor != delete.right) {
            parentSuccessor.setLeft(successor.right);
            successor.setRight(delete.right);
        }
        return successor;
    }
    public void printTree() throws IOException {
        RandomAccessFile randomAccessFile =
                new RandomAccessFile("Tree.txt","rw");
        randomAccessFile.setLength(0);
        Queue<Tree> queue = new LinkedList<>();
        queue.add(this);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tree curr = queue.poll();
                if (level > 2) {
                    randomAccessFile.write((curr.value + "(" + curr.parent.value + ") ").getBytes());
                    System.out.print(curr.value + "(" + curr.parent.value + ") ");
                }
                else {
                    randomAccessFile.write((curr.value + " ").getBytes());
                    System.out.print(curr.value + " ");
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            randomAccessFile.writeBytes("\n");
            System.out.println();
            level++;
        }
        randomAccessFile.close();
    }
}