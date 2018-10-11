package demo;

public class SingletonDemo {
	
}

/**
 * 饿汉式单例*/
class Singleton{
	//加载类时就实例化对象
	private static Singleton instance = new Singleton();
	private Singleton() {};
	
	public static Singleton getInstance() {
		return instance;
	}
}

/**
 * 懒汉式单例*/
class Singleton2{
	//类加载时不创建单例实例，在第一次请求实例时创建
	private static Singleton2 instance;
	private Singleton2() {};
	
	public static Singleton2 getSingleton() {
		if(instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
}

/**
 * 多线程下懒汉式单例模式，避免多次创建实例*/
class Singleton3{
	private static Singleton3 instance;
	private Singleton3() {};
	
	public static Singleton3 getSingleton() {
		if(instance == null) {//避免每次加锁，只有第一次没有创建对象时才加锁
			synchronized(Singleton3.class) {//加锁，只允许一个线程进入
				if(instance == null) {
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}
}





