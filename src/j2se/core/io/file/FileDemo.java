package j2se.core.io.file;


import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File(�ļ�) ʹ�����ŷ���
 */
public class FileDemo {

	public static void main(String[] args) throws IOException {
		// File.separator ��ʹ���ǵõ���ǰϵͳ���ļ��ָ���
		System.out.println(File.separator);
		// ��Ȼͨ��ϵͳ����Ҳ�ǿ��Եõ���
		System.out.println(System.getProperty("file.separator"));

		File file = new File("src/j2se/core/io/file/FileDemo.java");
		if (file.isFile())
			System.out.println(file + " ��һ���ļ���");
		
		showFileInfomation(file);
		
		createNewFile("newfile.txt");
		
		deleteFile("newfile.txt");
	}

	private static void deleteFile(String string) {
		File file = new File(string);
		if (file.exists())
			System.out.println("�ļ����ڵ�!");
		else
			System.out.println("�ļ������ڵ�!");
		
		if (file.delete())
			System.out.println("�ļ���ɾ����!");
		else
			System.out.println("�޷�ɾ���ļ�!");
		
		if (file.exists())
			System.out.println("�ļ����ڵ�!");
		else
			System.out.println("�ļ������ڵ�!");
	}

	private static void createNewFile(String string) throws IOException {
		File file = new File(string);
		if(!file.exists()){
			if (file.createNewFile())
				System.out.println("�ļ������ɹ�!");
			else
				System.out.println("�ļ�����ʧ��!");
		}else{
			System.out.println("�ļ��Ѿ�����!");
		}
		/*if (file.createNewFile())
			System.out.println("�ļ������ɹ�!");
		else
			System.out.println("�ļ��Ѿ�����!");*/
	}

	private static void showFileInfomation(File file) throws IOException {
		// ��ʾ��д��Ϣ
		System.out.println("�Ƿ�ɶ�:" + file.canRead());
		System.out.println("�Ƿ��д:" + file.canWrite());
		System.out.println("�ļ���С:" + file.length());
		System.out.println("����޸�ʱ��:" + new Date(file.lastModified()));
		
		// ��ʾ·����Ϣ
		System.out.println("����·��Ϊ:" + file.getAbsolutePath());
		System.out.println("�ļ���Ϊ:" + file.getName());
		System.out.println("����Ŀ¼Ϊ:" + file.getParent());
	}

}
