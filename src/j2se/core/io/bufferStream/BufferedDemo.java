package j2se.core.io.bufferStream;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 组合流对象的范例
 */
public class BufferedDemo {

	public static void main(String[] args) throws IOException {
		String dir = System.getProperty("user.dir");
		File file = new File(dir + "/src/j2se/core/io/bufferStream/BufferedDemo.java");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));
		
		int i;
		/*while (true) {
			i = reader.read();
			if (i == -1)
				break;
			writer.write(i);
		}
		*/
		String line;
		while((line=reader.readLine())!=null){
			writer.write(line);
			writer.write("\r\n");
		}
		writer.flush();
		writer.close();
		reader.close();
	}

}

