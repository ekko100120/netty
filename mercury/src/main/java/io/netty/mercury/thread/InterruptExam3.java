package io.netty.mercury.thread;


//处理线程中断的常用方法
//设置取消标记
public class InterruptExam3 {

    public static void main(String[] args) {
        Task task =new Task();
        Thread t1 = new Thread(task);
        t1.start();
        System.out.println("is start.............");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.cancel();
        System.out.println("cancel down........");

    }



    public static class Task implements Runnable{
        public boolean isCancel=false;
        @Override
        public void run() {
            while (!isCancel){
                System.out.println(" no go to interruption-------->");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("game over....");

        }
        public void cancel() {
            this.isCancel=true;
        }
    }
}
