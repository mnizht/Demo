package ThreadDemo;

/**
 * 通过内部类实现线程的共享变量*/
public class InnerShareThread {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.getThread().start();
		myThread.getThread().start();
		myThread.getThread().start();
	}
}
class MyThread{
	int num=0;
	private class InnerThread extends Thread{
		synchronized public void run() {
			for(int i=0;i<100;i++) {
				System.out.println(Thread.currentThread()
						.getName()+": "+num++);
			}
		}
	}
	
	public Thread getThread() {
		return new InnerThread();
	}
}
