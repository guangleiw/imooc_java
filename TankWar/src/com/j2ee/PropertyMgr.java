package com.j2ee;
import java.io.IOException;
import java.util.Properties;
/**
 * ����ģʽ  ��ȡ�����ļ�
 * @author wangguanglei1
 *
 */
public class PropertyMgr {

	static Properties props = new Properties();

	static {
		try {
			props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("conf/tank.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private PropertyMgr() {

	}

	public static String getProperty(String key) {
		return props.getProperty(key);
	}

}
