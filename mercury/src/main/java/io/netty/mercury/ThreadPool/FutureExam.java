package io.netty.mercury.ThreadPool;

import java.util.concurrent.*;

public class FutureExam {


    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                1,
                1,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>()
                );
        Future<?> future = executorService.submit(new Task());
    }


    static class Task implements Runnable{
        @Override
        public void run() {

        }
    }
}
