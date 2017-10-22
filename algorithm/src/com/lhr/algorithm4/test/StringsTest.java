package com.lhr.algorithm4.test;

import org.junit.Test;

import com.lhr.algorithm4.strings.sort.LSD;
import com.lhr.algorithm4.strings.sort.MSD;

public class StringsTest {

	@Test
	public void test() {
		MSD lsd = new MSD();
		String[] strings = getStringArray();
		lsd.sort(strings);
		for (String s : strings) {
			System.out.println(s);
		}
	}

	public Student[] getStudent() {
		Student stu1 = new Student("cac", 2);
		Student stu2 = new Student("fnc", 2);
		Student stu3 = new Student("edb", 4);
		Student stu4 = new Student("oel", 0);
		Student stu5 = new Student("akf", 2);
		Student stu6 = new Student("erk", 1);

		Student[] stus = { stu1, stu2, stu3, stu4, stu5, stu6 };
		return stus;
	}
	
	public String[] getStringArray() {
		return new String[] {"Java1","C++z2","Go3ll","C#4op","PythoLL","PHP65JDSA","Scala6666"};
	}

}

class Student {
	private String name;
	private int key;

	public Student(String name, int key) {
		super();
		this.name = name;
		this.key = key;
	}

	public int key() {
		return key;
	}

	@Override
	public String toString() {
		return name + ":" + key;
	}
}