package j2se.core.io.file;


import java.io.File;
import java.io.IOException;

/**
 * File(Ŀ¼) ʹ�����ŷ���
 */
public class DirectoryDemo {

	public static void main(String[] args) {
		File dir = new File("src/j2se/core/io/file");
		if (dir.isDirectory()) {
			System.out.println(dir + " �Ǹ�Ŀ¼");
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

	/** �����ļ���ͬʱ����Ŀ¼ */
	private static void createFileWithDir(String string) {
		File file = new File(string);
		if (file.exists())
			return;
		File dir = file.getParentFile();
		if (!dir.exists())
			dir.mkdirs();
		try {
			file.createNewFile();
			System.out.println("�ļ���Ŀ¼�����ɹ�!");
		} catch (IOException e) {
			System.out.println("�ļ���Ŀ¼����ʧ��!");
		}
	}

	/** ɾ��Ŀ¼�� */
	private static void deleteMultiDir(String string) {
		File dir = new File(string);
		if (!dir.exists())
			return;
		if (delete(dir))
			System.out.println("ɾ���ɹ�!");
		else
			System.out.println("ɾ��ʧ��!");
	}

	/** �ݹ�ɾ���ļ���Ŀ¼ */
	private static boolean delete(File current) {
		boolean flag = true;
		if (current.isDirectory())
			for (File file : current.listFiles())
				flag = flag && delete(file);
		return flag && current.delete();
	}

	/** ����Ŀ¼�� */
	private static void createMultiDir(String string) {
		File dir = new File(string);
		if (dir.exists())
			return;
		if (dir.mkdirs())
			System.out.println("Ŀ¼�������ɹ�!");
		else
			System.out.println("Ŀ¼������ʧ��!");
	}

	/** ɾ����һĿ¼ */
	private static void deleteSingleDir(String string) {
		File dir = new File(string);
		if (!dir.exists())
			return;
		if (dir.delete())
			System.out.println("ɾ���ɹ�!");
		else
			System.out.println("ɾ��ʧ��!");
	}

	/** ������һĿ¼ */
	private static void createSingleDir(String string) {
		File dir = new File(string);
		if (dir.exists())
			return;
		if (dir.mkdir())
			System.out.println("Ŀ¼�����ɹ�!");
		else
			System.out.println("Ŀ¼����ʧ��!");
	}
}
