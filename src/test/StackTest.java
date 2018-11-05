package test;

import stack.IStack;
import stack.impl.ArrayStack;
import stack.impl.LinkStack;

public class StackTest {
    public static void main(String[] args) {
        IStack<Integer> stack;
        stack = new ArrayStack<>(10);
        stack = new LinkStack<>();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 21; i++) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}
