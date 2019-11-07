package com.example.thread.base.two.Unsafe;

import sun.misc.Unsafe;

/**
 * @author ZhangNan
 * @date 2019/11/7 8:05
 */
public class UnsafeDemo1 {
	//获取Unsafe的实例
	static final Unsafe unsafe = Unsafe.getUnsafe();
	//记录state在类UssafeDemo1类中的偏移量
	static final long stateOffset;
	//变量
	private volatile long state =0;

	static {
		try{
			//获取state变量在类UnsafeDemo1中的偏移量
			stateOffset = unsafe.objectFieldOffset(UnsafeDemo1.class.getField("state"));
		}catch (Exception e){
			System.out.println(e.getLocalizedMessage());
			throw  new Error(e);
		}
	}
	public static void main(String[] args) {
		//创建实例,并设置state值为1
		UnsafeDemo1 unsafeDemo1 = new UnsafeDemo1();
		boolean b = unsafe.compareAndSwapInt(unsafeDemo1, stateOffset, 0, 1);
		System.out.println(b);
	}
}
