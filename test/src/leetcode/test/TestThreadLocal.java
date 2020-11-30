package leetcode.test;

import java.text.SimpleDateFormat;

public class TestThreadLocal {

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat();
        int threads = 10;
        for(int i = 1; i <= threads; i++) {
            new Thread(() -> {
                 ThreadLocal local = new ThreadLocal();
            }, "thread - " + i).start();
        }
    }

}
