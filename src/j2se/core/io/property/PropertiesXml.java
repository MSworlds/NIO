package j2se.core.io.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 读写配置文件范例二
 */
public class PropertiesXml {

	public static void main(String[] args) throws  IOException {
       String path= PropertiesXml.class.getClass().getResource("/").getPath();
        System.out.println(path);
		Properties prop = new Properties();
		
		File input = new File("config.xml");
		prop.loadFromXML(new FileInputStream(input));
		
		prop.setProperty("key", "value");
		
		File output = new File("new.xml");
		prop.storeToXML(new FileOutputStream(output), "属性列表的描述");
	}

}
