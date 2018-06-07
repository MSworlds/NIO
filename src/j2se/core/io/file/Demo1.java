package j2se.core.io.file;

import java.io.File;

public class Demo1 {
	public static void main(String[] args) {
        File file = new File("E:/201207/J2seSample_IO/config.properties");
        //System.out.println(file.getName());
        System.out.println(file.getParent());
        
	}
}
