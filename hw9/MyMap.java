import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
public class MyMap<K extends Comparable<K>,V> implements Map<K,V> {

    private Tree<K,V> root;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Tree<K extends Comparable<K>,V> {
        private Tree<K,V>  parent;
        private Tree<K,V>  left;
        private Tree<K,V>  right;
        private K key;
        private V value;
        public V get(K key) {
            Tree<K,V> current = this;
            while (current != null) {
                int cmp = key.compareTo(current.key);
                if (cmp == 0) {
                    return current.value;
                } else if (cmp < 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return null;
        }

        public void add(Tree<K,V> node) {
            Tree<K,V> parent = null;
            Tree<K,V> current = this;
            while (current != null) {
                parent = current;
                int cmp = node.key.compareTo(current.key);
                if (cmp == 0) {
                    current.value = node.value;
                    return;
                } else if (cmp < 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            node.parent = parent;
            if (parent == null) {
                this.key = node.key;
                this.value = node.value;
            } else if (node.key.compareTo(parent.key) < 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }

        public void remove(K key) {
            Tree<K,V> current = this;
            while (current != null) {
                int cmp = key.compareTo(current.key);
                if (cmp == 0) {
                    break;
                } else if (cmp < 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            if (current == null) {
                return;
            }
            if (current.left != null && current.right != null) {
                Tree<K,V> successor = current.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                current.key = successor.key;
                current.value = successor.value;
                current = successor;
            }
            Tree<K,V> child = current.left != null ? current.left : current.right;
            if (child != null) {
                child.parent = current.parent;
                if (current.parent == null) {
                    this.key = child.key;
                    this.value = child.value;
                } else if (current == current.parent.left) {
                    current.parent.left = child;
                } else {
                    current.parent.right = child;
                }
            } else if (current.parent == null) {
                this.key = null;
                this.value = null;
            } else {
                if (current == current.parent.left) {
                    current.parent.left = null;
                } else {
                    current.parent.right = null;
                }
            }
        }


    }

    @Override
    public int size() {
        if (root == null){
            return 0;
        }

        Queue<Tree<K,V>> queue = new ArrayDeque<>();
        int size = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            Tree<K,V> tree = queue.remove();

            if (tree.getLeft()!= null) {
                queue.add(tree.getLeft());
            }
            if (tree.getRight()!= null) {
                queue.add(tree.getRight());
            }
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean containsKey(Object key) {
        if (root == null) {
            return false;
        }
        Tree<K,V> node = (Tree<K, V>) root.get((K) key);
        return node != null;
    }

    @Override
    public boolean containsValue(Object value) {
        if (root == null) {
            return false;
        }
        Queue<Tree<K,V>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree<K,V> node = queue.remove();
            if (node.getValue().equals(value)) {
                return true;
            }
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        if (root == null) {
            return null;
        }
        Tree<K,V> node = (Tree<K, V>) root.get((K) key);
        return node == null ? null : node.getValue();
    }

    @Override
    public V put(K key, V value) {
        if (root == null) {
            root = new Tree<K,V>(null, null, null, key, value);
            return null;
        }
        Tree<K,V> current = root;
        while (true) {
            int cmp = key.compareTo(current.getKey());
            if (cmp == 0) {
                V oldValue = current.getValue();
                current.setValue(value);
                return oldValue;
            }

            if (cmp < 0) {
                if (current.getLeft() == null) {
                    current.setLeft(new Tree<K,V>(current, null, null, key, value));
                    return null;
                }
                current = current.getLeft();
            } else {
                if (current.getRight() == null) {
                    current.setRight(new Tree<K,V>(current, null, null, key, value));
                    return null;
                }
                current = current.getRight();
            }
        }
    }

    @Override
    public V remove(Object key) {
        Tree<K,V> node = (Tree<K, V>) get(key);

        if (node == null) {
            return null;
        }

        K result = node.key;

        if (node.left == null && node.right == null) {
            if (node.parent == null) {
                node.key = null;
                node.value = null;
            } else if (node == node.parent.left) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        } else if (node.left == null) {
            if (node.parent == null) {
                node.key = node.right.key;
                node.value = node.right.value;
                node.left = node.right.left;
                node.right = node.right.right;
            } else if (node == node.parent.left) {
                node.parent.left = node.right;
                node.right.parent = node.parent;
            } else {
                node.parent.right = node.right;
                node.right.parent = node.parent;
            }
        } else if (node.right == null) {
            if (node.parent == null) {
                node.key = node.left.key;
                node.value = node.left.value;
                node.right = node.left.right;
                node.left = node.left.left;
            } else if (node == node.parent.left) {
                node.parent.left = node.left;
                node.left.parent = node.parent;
            } else {
                node.parent.right = node.left;
                node.left.parent = node.parent;
            }
        } else {
            Tree<K,V> next = node.right;

            while (next.left != null) {
                next = next.left;
            }

            node.key = next.key;
            node.value = next.value;

            if (next == next.parent.left) {
                next.parent.left = next.right;
            } else {
                next.parent.right = next.right;
            }

            if (next.right != null) {
                next.right.parent = next.parent;
            }
        }

        return (V) result;

    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for(Map.Entry<? extends K,? extends V> entry: m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Set<K> keySet() {
        Set set = new HashSet<>();
        if (root != null) {
            addKeysRecursive(root, set);
        }
        return set;
    }
    private void addKeysRecursive(Tree<K,V> node, Set set) {
        if (node != null) {
            addKeysRecursive(node.left, set);
            set.add(node.key);
            addKeysRecursive(node.right, set);
        }
    }

    @Override
    public Collection<V> values() {
        List list = new ArrayList<>();
        if (root != null) {
            addValuesRecursive(root, list);
        }
        return list;

    }
    private void addValuesRecursive(Tree<K,V> node, List list) {
        if (node != null) {
            addValuesRecursive(node.left, list);
            list.add(node.value);
            addValuesRecursive(node.right, list);
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        if (root != null) {
            addEntriesRecursive(root, set);
        }
        return set;
    }
    private void addEntriesRecursive(Tree<K,V> node, Set<Entry<K, V>> set) {
        if (node != null) {
            addEntriesRecursive(node.left, set);
            set.add(new AbstractMap.SimpleEntry<>(node.key, node.value));
            addEntriesRecursive(node.right, set);
        }
    }
}
