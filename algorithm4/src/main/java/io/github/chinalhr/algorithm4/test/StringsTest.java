package io.github.chinalhr.algorithm4.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.chinalhr.algorithm4.strings.search.TrieST;
import io.github.chinalhr.algorithm4.strings.sort.MSD;
import io.github.chinalhr.algorithm4.strings.substring.BoyerMoore;
import io.github.chinalhr.algorithm4.strings.substring.ViolenceFind;

public class StringsTest {

	@Test
	public void testViolenceFind() {
		ViolenceFind find = new ViolenceFind();
		int i = find.searcha("lhr1996", getSubstringTxT());
		String substring = getSubstringTxT().substring(i,i+7);
		System.out.println(substring);
	}

	@Test
	public void testKMP() {
		BoyerMoore bm = new BoyerMoore("lhr1996");
		int i = bm.search(getSubstringTxT());
		String substring = getSubstringTxT().substring(i,i+7);
		System.out.println(substring);
	}


	@Test
	public void testTST() {
		TrieST<Integer> tst = new TrieST<>();
		tst.put("lhr1996", 999);
		tst.put("lhr1988", 999);
		tst.put("lnx1995", 888);
		tst.put("lcq1996", 777);
		tst.put("wyq", 666);
		tst.put("hpz", 555);
		Assert.assertTrue(tst.get("lhr")==999);
		Assert.assertTrue(tst.get("lnx")==888);
		Iterable<String> iterable1 = tst.keysWithPrefix("l");
		for (String string : iterable1) {
			System.out.println(string);
		}

	}

	@Test
	public void testMSD() {
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

	public String getSubstringTxT() {
		return "asdadjaslkdshfsdajalhr1996ksdkjasdsakfhiowequoiweqweqnzxkc";
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
