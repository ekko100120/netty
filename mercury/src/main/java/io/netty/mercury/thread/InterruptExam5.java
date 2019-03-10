package io.netty.mercury.thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


//处理不支持中断的线程中断的常用方法
//        改写线程的interrupt方法
public class InterruptExam5 {

    public static void main(String[] args) throws IOException {
        Thread thread = new TaskJob(new Socket());
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    static class TaskJob extends Thread{
         static final int BUFFER_SIZE = 512;
         Socket socket;
         InputStream inputStream;


        public TaskJob(Socket socket) throws IOException {
            this.socket = socket;
            this.inputStream = socket.getInputStream();
        }

        @Override
        public void interrupt() {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                super.interrupt();
            }
            super.interrupt();
        }

        @Override
        public void run() {
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                while (true){
                    int count = inputStream.read(buf);
                    if (count<0){
                        break;
                    }else if (count>0){

                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
