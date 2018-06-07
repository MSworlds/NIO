package j2se.core.io.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 读写配置文件范例一
 */
public class PropertiesFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		
		File input = new File("config.properties");
		prop.load(new FileInputStream(input));
		//prop.load(new FileReader(input));
		
		System.out.println(prop.getProperty("ip"));
		prop.setProperty("key", "value");
		
		File output = new File("config/new.properties");
		prop.store(new FileOutputStream(output), "属性列表的描述");
		// prop.store(new FileWriter(output), "属性列表的描述");
        prop.propertyNames();
	}


}
