package j2se.core.io.bufferStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo3 {
	public static void main(String[] args) {
		String source = "assert/�ݺ�.mp3";
		String desc = "E:/assert/�ݺ�.mp3";

		File souceFile = new File(source);
		File descFile = new File(desc);
		if (!descFile.getParentFile().exists()) {
			descFile.getParentFile().mkdir();
		}
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
				in = new BufferedInputStream(new FileInputStream(souceFile)) ;
				out = new BufferedOutputStream(new FileOutputStream(descFile)) ;
				byte[] bytes =new byte[4096];
				int len=-1;
				System.out.println("�������ݿ�ʼ...");
				while((len=in.read(bytes, 0, bytes.length))!=-1){
					System.out.println("���ݿ�����...");
				    out.write(bytes, 0, len);
				}
				System.out.println("�������ݽ�����");
					
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
