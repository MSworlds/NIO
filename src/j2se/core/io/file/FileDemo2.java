package j2se.core.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDemo2 {
	public static void main(String[] args) {
		String fromFile = "E:\\AndroidWebClient.rar";
		String toFile = "AndroidWebClient.rar";
		FileInputStream inStream = null;
		FileOutputStream outStream = null;
		try {
			File inFile = new File(fromFile);
			File outFile = new File(toFile);
			
			inStream = new FileInputStream(inFile);
			outStream = new FileOutputStream(outFile);
			
			int len=-1;
			byte[] bytes=new byte[1024];
			System.out.println("开始复制！");
			while((len=inStream.read(bytes, 0, bytes.length))!=-1){
				Thread.sleep(10);
				System.out.println("复制中....");
				outStream.write(bytes, 0, len);
			}
			System.out.println("全部复制成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("全部复制失败！");
		}finally{
			try {
				inStream.close();
				outStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
