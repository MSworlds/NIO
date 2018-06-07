package j2se.core.io.file;


import java.io.File;
import java.io.IOException;

/**
 * File(目录) 使用入门范例
 */
public class DirectoryDemo {

	public static void main(String[] args) {
		File dir = new File("src/j2se/core/io/file");
		if (dir.isDirectory()) {
			System.out.println(dir + " 是个目录");
		}
		
		for (String s : dir.list()) {
			System.out.println(s);
		}
		
		createSingleDir("src/j2se/core/io/file/test1");
		deleteSingleDir("test1");
		
		createMultiDir("test2/dir");
		deleteMultiDir("test2");
		
		createFileWithDir("test3/a.txt");
	    deleteMultiDir("test3");
	}

	/** 创建文件的同时创建目录 */
	private static void createFileWithDir(String string) {
		File file = new File(string);
		if (file.exists())
			return;
		File dir = file.getParentFile();
		if (!dir.exists())
			dir.mkdirs();
		try {
			file.createNewFile();
			System.out.println("文件与目录创建成功!");
		} catch (IOException e) {
			System.out.println("文件或目录创建失败!");
		}
	}

	/** 删除目录树 */
	private static void deleteMultiDir(String string) {
		File dir = new File(string);
		if (!dir.exists())
			return;
		if (delete(dir))
			System.out.println("删除成功!");
		else
			System.out.println("删除失败!");
	}

	/** 递归删除文件或目录 */
	private static boolean delete(File current) {
		boolean flag = true;
		if (current.isDirectory())
			for (File file : current.listFiles())
				flag = flag && delete(file);
		return flag && current.delete();
	}

	/** 创建目录树 */
	private static void createMultiDir(String string) {
		File dir = new File(string);
		if (dir.exists())
			return;
		if (dir.mkdirs())
			System.out.println("目录树创建成功!");
		else
			System.out.println("目录树创建失败!");
	}

	/** 删除单一目录 */
	private static void deleteSingleDir(String string) {
		File dir = new File(string);
		if (!dir.exists())
			return;
		if (dir.delete())
			System.out.println("删除成功!");
		else
			System.out.println("删除失败!");
	}

	/** 创建单一目录 */
	private static void createSingleDir(String string) {
		File dir = new File(string);
		if (dir.exists())
			return;
		if (dir.mkdir())
			System.out.println("目录创建成功!");
		else
			System.out.println("目录创建失败!");
	}
}
