package ThreadDemo;

public class RunnableTest {
	public static void main(String[] args) {
		//同一个对象创建的线程num共享
		RunnableThread runnableThread = new RunnableThread();
		new Thread(runnableThread).start();
		new Thread(runnableThread).start();
		new Thread(runnableThread).start();
		
		RunnableThread runnableThread2 = new RunnableThread();
		new Thread(runnableThread2).start();
		new Thread(runnableThread2).start();
		new Thread(runnableThread2).start();
	}

}

class RunnableThread implements Runnable {
	//多个线程之间共享num
	int num = 0;

	synchronized public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().
					getName() + ": " + num++);
		}
	}
}
