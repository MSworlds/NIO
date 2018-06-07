package j2se.core.io.charsetStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Demo01 {
	public static void main(String[] args) {
		String inFileName = "src/j2se/core/io/file/Demo1.java";
		String outFileName = "Demo2.java";

		File inFile = new File(inFileName);
		File outFile = new File(outFileName);

		Reader fr = null;
		Writer fw = null;

		try {
			fr = new BufferedReader(new FileReader(inFile)) ;
			fw = new BufferedWriter( new FileWriter(outFile));
			char[] data = new char[200];
			int len=-1;
			while((len=fr.read(data, 0, data.length))!=-1){
				fw.write(data, 0, len);
			}
			System.out.println("数据复制成功！");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
