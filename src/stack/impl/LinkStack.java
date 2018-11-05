package stack.impl;

import stack.IStack;

public class LinkStack<E> implements IStack<E> {
    private Node<E> first;//表头

    @Override
    synchronized public void push(E e) {
        if (first==null){
            first = new Node<>(e,null);
            return;
        }
        findLast(first).next = new Node<>(e,null);
    }

    @Override
    synchronized public E pop() {
        E e = peek();
        if (e!=null)
            findLast(first).item =null;//gc
        return e;
    }

    @Override
    synchronized public E peek() {
        if (first==null)
            return null;
        if (first.item==null){
            first = null;//gc
            return null;
        }
        return findLast(first).item;
    }

    @Override
    synchronized public boolean isEmpty() {
        return findLast(first) == null;
    }

    synchronized private Node<E> findLast(Node<E> node){
        if (node==null)
            return null;
        if (node.next!=null){
            if (node.next.item==null){
                node.next = null;//gc
                return node;
            }
            return findLast(node.next);
        }else {
            return node;
        }
    }

    private class Node<E>{
        E item;
        Node<E> next;
        Node(E item,Node<E> next){
            this.item = item;
            this.next = next;
        }
    }
}
