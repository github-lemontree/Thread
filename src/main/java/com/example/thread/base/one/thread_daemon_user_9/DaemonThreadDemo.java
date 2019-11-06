package com.example.thread.base.one.thread_daemon_user_9;


/**
 * @author zhangnan
 * @Date 2019/11/5 23:16
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(()->{
            for(;;){

            }
        });
        //设置为守护线程
        //daemonThread.setDaemon(true);
        daemonThread.start();
        System.out.println("main is over");
    }
}
