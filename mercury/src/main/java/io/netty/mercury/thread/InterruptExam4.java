package io.netty.mercury.thread;


//通过interrupt 和 isinterrupt 方法来中断线程
public class InterruptExam4 {
    public static void main(String[] args) {
        TaskJob taskJob = new TaskJob();
        Thread thread1 = new Thread(taskJob);
        thread1.start();
        System.out.println("thread is start .........");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start interrupt...."+System.currentTimeMillis());
        thread1.interrupt();
        System.out.println("end interrupt...."+System.currentTimeMillis());
    }


    public static class TaskJob implements Runnable{

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("meiyou jinru zhongduan .......");
                try {
//                    System.out.println(Thread.currentThread().isInterrupted());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                }

            }
            System.out.println("wo yijing jieshu le ..........");
        }
    }
}
