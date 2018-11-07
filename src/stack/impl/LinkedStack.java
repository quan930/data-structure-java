package stack.impl;

import stack.IStack;

public class LinkedStack<E> implements IStack<E> {
    private Node<E> head;

    @Override
    synchronized public void push(E e) {
        head = new Node<>(e,head);
    }

    @Override
    synchronized public E pop() {
        if (isEmpty())
            return null;
        E item = head.item;
        head.item = null;//gc
        head = head.next;
        return item;
    }

    @Override
    synchronized public E peek() {
        if (isEmpty())
            return null;
        else
            return head.item;
    }

    @Override
    synchronized public boolean isEmpty() {
        return head==null;
    }

    private class Node<E>{
        E item;
        Node<E> next;
        Node(E item, Node<E> next){
            this.item = item;
            this.next = next;
        }
    }
}
