package j2se.core.io.charsetStream;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Reader 入门使用范例
 */
public class ReaderDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("src/j2se/core/io/file/FileDemo.java");
		Reader reader = new FileReader(file);
		//int i = reader.read();
		//System.out.println(i + " " + (char) i);
		
		char[] array = new char[200];
		/*while (true) {
			i = reader.read(array);
			if (i == -1)
				break;
			for (int j = 0; j < i; j++)
				System.out.print(array[j]);
		}*/
		
		int len= -1;
		while((len=reader.read(array,0,array.length))!=-1){
			for (int j = 0; j < len; j++)
				System.out.print(array[j]);
		}
		reader.close();
		
	}

}
