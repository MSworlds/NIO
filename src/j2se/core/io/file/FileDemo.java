package j2se.core.io.file;


import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File(文件) 使用入门范例
 */
public class FileDemo {

	public static void main(String[] args) throws IOException {
		// File.separator 可使我们得到当前系统的文件分隔符
		System.out.println(File.separator);
		// 当然通过系统属性也是可以得到的
		System.out.println(System.getProperty("file.separator"));

		File file = new File("src/j2se/core/io/file/FileDemo.java");
		if (file.isFile())
			System.out.println(file + " 是一个文件。");
		
		showFileInfomation(file);
		
		createNewFile("newfile.txt");
		
		deleteFile("newfile.txt");
	}

	private static void deleteFile(String string) {
		File file = new File(string);
		if (file.exists())
			System.out.println("文件存在的!");
		else
			System.out.println("文件不存在的!");
		
		if (file.delete())
			System.out.println("文件被删除了!");
		else
			System.out.println("无法删除文件!");
		
		if (file.exists())
			System.out.println("文件存在的!");
		else
			System.out.println("文件不存在的!");
	}

	private static void createNewFile(String string) throws IOException {
		File file = new File(string);
		if(!file.exists()){
			if (file.createNewFile())
				System.out.println("文件创建成功!");
			else
				System.out.println("文件创建失败!");
		}else{
			System.out.println("文件已经存在!");
		}
		/*if (file.createNewFile())
			System.out.println("文件创建成功!");
		else
			System.out.println("文件已经存在!");*/
	}

	private static void showFileInfomation(File file) throws IOException {
		// 显示读写信息
		System.out.println("是否可读:" + file.canRead());
		System.out.println("是否可写:" + file.canWrite());
		System.out.println("文件大小:" + file.length());
		System.out.println("最后修改时间:" + new Date(file.lastModified()));
		
		// 显示路径信息
		System.out.println("绝对路径为:" + file.getAbsolutePath());
		System.out.println("文件名为:" + file.getName());
		System.out.println("所在目录为:" + file.getParent());
	}

}
