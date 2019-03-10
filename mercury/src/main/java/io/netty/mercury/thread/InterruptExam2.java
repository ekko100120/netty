package io.netty.mercury.thread;

public class InterruptExam2 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
//        Thread.currentThread().interrupt();
        thread1.start();
        System.out.println("is starting------------>");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(Thread.currentThread().isInterrupted());
//        Thread.currentThread().interrupt();
//        System.out.println(Thread.currentThread().isInterrupted());
        thread1.interrupt();
        System.out.println("thread is interrupt------->");

    }

    public static class  Task implements Runnable{
        @Override
        public void run() {
            while (true){
                System.out.println("----------------------------------------------------------");
                System.out.println("not go into interrupt, current thread state is "+Thread.currentThread().isInterrupted());
//                System.out.println("not go into interrupt, current thread state is "+Thread.interrupted());
                System.out.println("not go into interrupt, current thread state is "+Thread.currentThread().isInterrupted());
                System.out.println("----------------------------------------------------------");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
