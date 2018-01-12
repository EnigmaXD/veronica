package com.veronica.base;

public class TestClass implements Runnable {
    private Integer a;

    public TestClass(Integer a) {
        this.a = a;
        System.out.println("thread start");
    }

    public void run() {
        while (true) {
            System.out.println("testFun:" + a);
            a++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
