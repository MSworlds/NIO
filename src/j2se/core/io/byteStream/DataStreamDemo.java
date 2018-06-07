package j2se.core.io.byteStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DataStream Ê¹ÓÃ·¶Àý
 */
public class DataStreamDemo {
	
	private static final String FILENAME = "data/data.dat";

	public static void main(String[] args) throws IOException {
		Person[] persons = {
				new Person("zhang", 32, true), 
				new Person("lishi", 31, false)
		};
		writeToFile(persons);
		
		persons = readFromFile();
		
		/*for(Person p:persons){
			System.out.println(p);
		}*/
		//System.out.println(persons);
		System.out.println(Arrays.toString(persons));
	}

	private static Person[] readFromFile() throws IOException {
		File file = new File(FILENAME);
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(file)));
		List<Person> list = new ArrayList<Person>();
		try {
			while(true) {
				Person p = new Person();
				p.name = in.readUTF();
				p.age = in.readInt();
				p.sex = in.readBoolean();
				list.add(p);
			}
		} catch (EOFException e) {
			
		}
		in.close();
		return list.toArray(new Person[0]);
	}

	private static void writeToFile(Person[] persons) throws IOException {
		File file = new File(FILENAME);
		DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(file)));
		for (Person p : persons) {
			out.writeUTF(p.name);
			out.writeInt(p.age);
			out.writeBoolean(p.sex);
		}
		out.flush();
		out.close();
	}

}

class Person {
	String name;
	Integer age;
	Boolean sex;
	
	public Person() {}
	
	public Person(String name, Integer age, Boolean sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}
}