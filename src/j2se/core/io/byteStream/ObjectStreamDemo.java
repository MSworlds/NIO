package j2se.core.io.byteStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 对象序列化说明范例
 */
public class ObjectStreamDemo {
	
	private static final String FILENAME = "data/object.dat";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Human[] humans = {
				new Human("zhang", 32, true), 
				new Human("lishi", 31, false)
		};
		
		writeToFile(humans);
		
		humans = readFromFile();
		System.out.println(Arrays.toString(humans));
	}

	private static Human[] readFromFile() throws IOException, ClassNotFoundException {
		File file = new File(FILENAME);
		ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(file)));
		List<Human> list = new ArrayList<Human>();
		try {
			while(true) {
				Human h = (Human) in.readObject();
				list.add(h);
			}
		} catch (EOFException e) {
		}
		in.close();
		return list.toArray(new Human[0]);
	}

	private static void writeToFile(Human[] humans) throws IOException {
		File file = new File(FILENAME);
		ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(file)));
		for (Human h : humans) {
			out.writeObject(h);
		}
		
		//Human hh = new Human("test", 18, true);
		//out.writeObject(hh);
		out.flush();
		out.close();
		
		
	}

}

class Human implements Serializable {
	private static final long serialVersionUID = -5448627462478900075L;
	String name;
	Integer age;
	Boolean sex;
	
	public Human() {}
	
	public Human(String name, Integer age, Boolean sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Human [age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}
}
