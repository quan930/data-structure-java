package test;

import stack.IStack;
import stack.impl.ArrayStack;
import stack.impl.LinkedStack;

import java.util.Stack;

/**
 * 10000000条数据
 * 链表：add 6000 remove 50
 * 数组：add 2400 remove 170
 */

public class StackTest {
    public static void main(String[] args) {
        IStack<Integer> stack;
        stack = new LinkedStack<>();
        stack = new ArrayStack<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            stack.push(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("push time:"+(end-start));
        long startPop = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
//            System.out.println(stack.pop());
            stack.pop();
        }
        long endPop = System.currentTimeMillis();
        System.out.println("pop time:"+(endPop-startPop));
    }
}
