package j2se.core.io.byteStream;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ʹ���ֽ�����ȡ�ı����ݣ���ɱ���ת���ķ���
 */
public class CharsetDemo {

	public static void main(String[] args) throws IOException {
		//error("txt/utf8.txt");
		//System.out.println("-------------------");
		//right("txt/gbk.txt", "GBK");
		test("txt/utf8.txt");
	}
	
	private static void right(String filepath, String charset) throws IOException {
		File file = new File(filepath);
		InputStreamReader input = new InputStreamReader(
				new BufferedInputStream(new FileInputStream(file)), 
				charset);
		char[] array = new char[50];
		int i;
		while ( (i = input.read(array)) != -1) {
			for (int j = 0; j < i; j++)
				System.out.print(array[j]);
		}
	}

	private static void error(String filepath) throws IOException {
		File file = new File(filepath);
		
		// ʹ�� Reader ��ʵ��
		/*BufferedReader reader = new BufferedReader(new FileReader(file));
		String s;
		while ( (s = reader.readLine()) != null ) {
			System.out.println(s);
		}*/
		
		
		/*BufferedInputStream input = new BufferedInputStream(
				new FileInputStream(file));
		int i;
		while ( (i = input.read()) != -1) {
			System.out.print((char) i);
		}*/
		
		FileInputStream in = new FileInputStream(file);
		int len =-1;
		byte[] bytes = new byte[1024];
		while((len=in.read(bytes,0,bytes.length))!=-1){
			String str = new String(bytes,"UTF-8");
			//System.out.println(str,);
		}
			
		
		
		
	}
	
	private static void test(String filepath) throws IOException {
		File file = new File(filepath);
		
		// ʹ�� Reader ��ʵ��
		/*BufferedReader reader = new BufferedReader(new FileReader(file));
		String s;
		while ( (s = reader.readLine()) != null ) {
			System.out.println(s);
		}*/
		
		
		/*BufferedInputStream input = new BufferedInputStream(
				new FileInputStream(file));
		int i;
		while ( (i = input.read()) != -1) {
			System.out.print((char) i);
		}*/
		
		FileInputStream in = new FileInputStream(file);
		int len =-1;
		byte[] bytes = new byte[1024];
		while((len=in.read(bytes,0,bytes.length))!=-1){
			//String str = new String(bytes);
			String str = new String(bytes,"UTF-8");
			System.out.println(str);
		}
	}

}

