package com.example.thread.base.thread_ThreadLocal;

/**
 * @author zhangnan
 * @Date 2019/11/5 23:43
 */
public class ThreadLocalDemo1 {


    //print 函数
    static void print(String str){
        System.out.println(str + ":" + localVariable.get());
        //清空当前线程本地内存中的localVariable值
        //localVariable.remove();
    }
    static ThreadLocal<String> localVariable = new ThreadLocal<>();
    public static void main(String[] args) {
        Thread threadOne = new Thread(()->{
            //设置线程One中本地变量localVariable的值
            localVariable.set("threadOne local variable");
            print("threadOne");
            System.out.println("threadOne remove after" + ":" + localVariable.get());
        });

        Thread threadTwo = new Thread(()->{
            localVariable.set("threadTwo local variable");
            print("threadTwo");
            System.out.println("threadTwo remove after" + ":" + localVariable.get());
        });
        threadOne.start();
        threadTwo.start();
    }
}
