package com.imooc.test;

public class TryCatchTest {

	public TryCatchTest() {
		// TODO Auto-generated constructor stub
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		TryCatchTest tct = new TryCatchTest();
//		int result = tct.test();
//		System.out.println("test方法执行完毕");
//		
//		int result2 = tct.test2();
//		System.out.println("test2 执行完成 哈哈了"+result2);
//	}

	/**
	 * divider result try catch 捕获while循环
	 * 
	 * @return
	 */
	public int test() {
		int divider = 10;
		int result = 100;
		try {
			while (divider > -1) {
				divider--;
				result = result + 100 / divider;
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("循环抛出异常了");
			return -1;
		}
	}

	public int test2() {
		int divider = 10;
		int result = 100;
		try {
			while (divider > -1) {
				divider--;
				result = result + 100 / divider;
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("循环抛出异常了");
			result = 999;;
		}finally {
			System.out.println("这是finally 哈哈");
			System.out.println("我是result ，  我的值为"+result);
		}
		return 0;
	}

}
