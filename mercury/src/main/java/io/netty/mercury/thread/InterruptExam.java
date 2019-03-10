package io.netty.mercury.thread;

public class InterruptExam {

    public static void main(String[] args) {
        A a = new A();
        Thread thread1 = new Thread(a);
        thread1.start();
        thread1.interrupt();
        System.out.println("before sleep, t1 thread state tag:"+thread1.isInterrupted());

        try {
            System.out.println("before sleep, t1 thread state tag:"+thread1.isInterrupted());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("after sleep, t1 thread state tag:"+thread1.isInterrupted());
        }
    }
    static class A implements Runnable{
        @Override
        public void run() {
            System.out.println("--------------------->");
            System.out.println("---current thread: "+Thread.currentThread());
            System.out.println("---"+Thread.currentThread().getName()+" state:"+Thread.interrupted());
            System.out.println("--------------------->");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
