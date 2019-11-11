package com.example.thread.base.two.伪共享;

/**
 * @author ZhangNan
 * @date 2019/11/7 18:42
 */
public class Demo1 {
	/**
	 *程序访问的局部性原则导致了伪共享的现象
	 */
	static final int LINE_NUM = 1024;
	static final int COLUM_NUM = 1024;

	public static void main(String[] args) {
		long[][] array = new long[LINE_NUM][COLUM_NUM];
		long startTime = System.currentTimeMillis();
		for(int i = 0;i<LINE_NUM;i++){
			for(int j = 0;j<COLUM_NUM;j++){
				array[i][j] = i*2+j;
			}
		}
		long endTime = System.currentTimeMillis();
		long cacheTime = endTime-startTime;
		System.out.println("cache time:" + cacheTime);
	}
}

class Demo2{
	static final int LINE_NUM = 1024;
	static final int COLUM_NUM = 1024;

	public static void main(String[] args) {
		long[][] array = new long[LINE_NUM][COLUM_NUM];
		long startTime = System.currentTimeMillis();
		for(int i =0;i<COLUM_NUM;i++){
			for(int j = 0;j<LINE_NUM;j++){
				array[j][i] =i*2+j;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("no cache time:" + (endTime - startTime));
	}
}