package stack.impl;

import stack.IStack;

import java.util.Arrays;

public class ArrayStack<E> implements IStack<E> {
    private final int MIN_CAPACITY = 10;
    private int capacity;
    private int size;
    private E[] array;

    public ArrayStack(){
        capacity = MIN_CAPACITY;
        this.array = (E[]) new Object[capacity];
        this.size = 0;
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
        decrease();
        E e = peek();
        if (e!=null)
            array[--size] = null;
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

    synchronized private void decrease(){//缩容
        if (size<=capacity/2&&size>MIN_CAPACITY){
            capacity = capacity/2;
            array = Arrays.copyOf(array,capacity);
        }
    }
}
