package com.imooc.test;

public class TryCatchTest {

	public TryCatchTest() {
		// TODO Auto-generated constructor stub
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		TryCatchTest tct = new TryCatchTest();
//		int result = tct.test();
//		System.out.println("test����ִ�����");
//		
//		int result2 = tct.test2();
//		System.out.println("test2 ִ����� ������"+result2);
//	}

	/**
	 * divider result try catch ����whileѭ��
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
			System.out.println("ѭ���׳��쳣��");
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
			System.out.println("ѭ���׳��쳣��");
			result = 999;;
		}finally {
			System.out.println("����finally ����");
			System.out.println("����result ��  �ҵ�ֵΪ"+result);
		}
		return 0;
	}

}
