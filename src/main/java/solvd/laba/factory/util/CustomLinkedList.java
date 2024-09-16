package solvd.laba.factory.util;


import java.util.*;

public class CustomLinkedList<E> implements List<E>, Iterable<E> {
    int size = 0;
    Node<E> first;
    Node<E> last;

    public CustomLinkedList(){
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        E e = (E) o;
        for (Node<E> node = first; node.next != null; node = node.next) {
            if (e == null) {
                if (node.element == null) {
                    return true;
                }
            } else {
                if (e.equals(node.element)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = first;
            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public E next() {
                node = node.next;
                return node.element;
            }
        };
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public boolean add(E e) {
        if (last == null) {
            first = new Node<>(null, e, null);
            last = first;
        } else {
            Node<E> newNode = new Node<>(last, e, null);
            last.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    private boolean removeNode(Node<E> node) {
        Node<E> prev = node.prev;
        if (node.prev == null) {
            first = node.next;
        } else {
            node.prev.next = node.next;
            node.prev = null;
        }
        if (node.next == null) {
            last = prev;
        } else {
            node.next.prev = prev;
            node.next = null;
        }
        node.element = null;
        size--;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        E e = (E) o;
        for (Node<E> node = first; node.next != null; node = node.next) {
            if (e == null) {
                if (node.element == null) {
                    removeNode(node);
                    return true;
                }
            } else {
                if (e.equals(node.element)) {
                    removeNode(node);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public void clear() {
        Node<E> node = first;
        while (node.next != null) {
            Node<E> next = node.next;
            node.next = null;
            node.prev = null;
            node.element = null;
            node = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (Object o : c) {
            remove(o);
        }
        return true;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.isEmpty()) {
            return true;
        }
        for (Object o : c) {
            if(!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomLinkedList<?> that)) return false;

        if (size != that.size) return false;
        Iterator i1 = ((CustomLinkedList<?>) o).iterator();
        Iterator<E> i2 = this.iterator();
        while (i1.hasNext() && i2.hasNext()) {
            E o1 = i2.next();
            Object o2 = i1.next();
            if (!(Objects.equals(o1, o2))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = size;
        for(E element : this) {
            result = 31 * result + (element != null ? element.hashCode() : 0);
        }
        return result;
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
