package stack.impl;

import stack.IStack;

import java.util.Arrays;

public class ArrayStack<E> implements IStack<E> {
    private int capacity;
    private int size;
    private E[] array;

    public ArrayStack(){
        this(10);
    }

    public ArrayStack(int capacity){
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
        this.size = 0;
    }

    @Override
    synchronized public void push(E e) {
        grow();
        array[size] = e;
        size++;
    }

    @Override
    synchronized public E pop() {
        E e = peek();
        if (e!=null){
            array[--size] = null;
        }
        return e;
    }

    @Override
    synchronized public E peek() {
        if (size<=0){
            return null;
        }
        return array[size-1];
    }

    @Override
    synchronized public boolean isEmpty() {
        return size == 0;
    }

    private void grow(){//扩容
        if (size>=capacity){
            capacity = capacity*2;
            array = Arrays.copyOf(array, capacity);
        }
    }
}
