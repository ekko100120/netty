package io.netty.mercury.tool;

import java.util.Random;
import java.util.concurrent.*;

public class CountDownLatchExam {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5 ; i++) {
            service.submit(new Horse("Horse "+i, latch));
        }
        for (int i = 0; i < 3; i++) {
            service.submit(new Judge("Judge "+i,latch));
        }
        service.shutdown();
    }

    public static class Horse implements Runnable{
        private final String name;
        private final CountDownLatch latch;



        public Horse(String name, CountDownLatch latch) {
            this.name = name;
            this.latch = latch;
        }

        @Override
        public void run() {

            System.out.println(name + " is ready,wait for all judges.");
            try {
                latch.await();
                System.out.println(name+ " is runing.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class Judge implements Runnable {

        private final String name;
        private final CountDownLatch latch;
        public static Random random = new Random(System.currentTimeMillis());

        public Judge(String name, CountDownLatch latch) {
            this.name = name;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(6));
                System.out.println(name + " is ready .");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
