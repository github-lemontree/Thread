package com.example.thread.base.two.Unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author ZhangNan
 * @date 2019/11/7 8:18
 */
public class UnsafeDemo2 {
	static final Unsafe unsafe;
	static final long stateOffset;
	private volatile long state = 0;
	static{
		try {
			//使用反射获取Unsafe的成员变量theUnsafe
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			//设置为可存取
			field.setAccessible(true);
			//获取该变量的值
			unsafe = (Unsafe)field.get(null);
			//获取state在UnsafeDemo2中的偏移量
			stateOffset = unsafe.objectFieldOffset(UnsafeDemo2.class.getDeclaredField("state"));
		}catch (Exception e){
			System.out.println(e.getLocalizedMessage());
			throw new Error(e);
		}
	}

	public static void main(String[] args) {
		UnsafeDemo2 unsafeDemo2 = new UnsafeDemo2();
		boolean b = unsafe.compareAndSwapInt(unsafeDemo2, stateOffset, 0, 1);
		System.out.println(b);

	}
}
