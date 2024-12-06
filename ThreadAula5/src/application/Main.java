package application;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

	static AtomicInteger i = new AtomicInteger();
	
	public static void main(String[] args) {
		Runnable runnable = new MyRunnable();

		Thread thread0 = new Thread(runnable);
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		Thread thread3 = new Thread(runnable);
		Thread thread4 = new Thread(runnable);
		
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
	
	
	static class MyRunnable implements Runnable {
		
		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " : " + i.incrementAndGet());
		}
	}

}
