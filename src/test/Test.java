package test;

import test.concurrent.ConcurrentTest;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    static int m = 0;
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        new ConcurrentTest().begin(10,()->{
            for (int i = 0; i < 10000; i++) {
//                integer.addAndGet(1);
                m++;
            }
        },()-> System.out.println(m));
    }
}
