package j2se.core.io.charsetStream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

/**
 * LineNumberReader Ê¹ÓÃ·¶Àý
 */
public class LineNumberReaderDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("src/j2se/core/io/charsetStream/LineNumberReaderDemo.java");
		/*LineNumberReader reader = new LineNumberReader(
				new BufferedReader(
						new FileReader(file)));*/
		
		LineNumberReader reader = new LineNumberReader(new FileReader(file));
		String s;
		while ( (s = reader.readLine()) != null ) {
			System.out.print(reader.getLineNumber() + "\t:\t");
			System.out.println(s);
		}
			
	}
	
	

}
