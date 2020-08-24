package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *
 * <h3>单例实现(基于静态内部类初始化)</h3>
 */
public class N01_Singleton2 {

	private N01_Singleton2() {};

	private static class InstanceHolder{
		public static N01_Singleton2 instance = new N01_Singleton2();
	}

	public static N01_Singleton2 getInstance() {
		return InstanceHolder.instance;
	}
}
