package io.github.chinalhr.sword_finger_offer;

/**
 *
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>单例实现（基于双重判null懒汉式）</h3>
 * <pre>
 * ①加锁(synchronized)的原因：多线程环境下避免多次创建实例
 * ②双重判null的原因：
 * 		-个null：在对象已经初始化的情况下,能够直接返回对象实例不用加锁，提升性能
 *  	二个null：懒汉式singleton的实现
 * ③volatile的原因：
 * singleton = new N01_Singleton()创建对象实际上是分三步进行的（重排序）
 *  	一：分配对象内存
 *  	二：初始化对象
 *  	三：实例指向内存地址
 *  所以：如果发生重排序，可能对象还没初始化，另一个线程在第一个判断null的时候判断对象不为null而获取到未初始化的实例，导致错误。
 *  	声明voilatile可以禁止重排序
 *  </pre>
 */
public class N01_Singleton {

	private N01_Singleton() {
	}

	private static volatile N01_Singleton singleton = null;

	public static N01_Singleton getInstance() {
		if(singleton == null) {
			synchronized (N01_Singleton.class) {
				if(singleton == null)
					singleton = new N01_Singleton();
			}
		}
		return singleton;
	}
}
