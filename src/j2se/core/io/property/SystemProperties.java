package j2se.core.io.property;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Map.Entry;

/**
 * ϵͳ����ʹ�÷���
 */
public class SystemProperties {

	public static void main(String[] args) {
		Properties prop = System.getProperties();
		
		// �г�ȫ��ϵͳ��������
		for (Entry<Object, Object> entry : prop.entrySet()) {
			System.out.print("KEY: " + entry.getKey() + "\t");
			System.out.println("VALUE: " + entry.getValue());
		}
		// prop.list(System.out); // �÷���Ҳ�����г�ȫ��ϵͳ����
		
		// ���ָ��ϵͳ��������
		String version = prop.getProperty("java.version");
		System.out.println(version);
		
		String dir = prop.getProperty("user.dir");
		System.out.println("dir="+dir);
		
		// ����ϵͳ����
		setProperty("mykey", "myvalue");
		System.out.println(prop.getProperty("mykey", "default"));
		
		// �г�ȫ��ϵͳ������
		Enumeration<String> names = (Enumeration<String>) prop.propertyNames();
		while (names.hasMoreElements()) {
			String s = names.nextElement();
			System.out.println(s);
		}
	}
	
	private static void setProperty(String key, String value) {
		Properties prop = System.getProperties();
		prop.setProperty(key, value);
	}

}
