package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static List<String> list = Collections.synchronizedList(new ArrayList<>());

	public static void main(String[] args) throws InterruptedException {
		MyRunnable myRunnable = new MyRunnable();
		
		
		Thread thread0 = new Thread(myRunnable);		
		Thread thread1 = new Thread(myRunnable);
		Thread thread2 = new Thread(myRunnable);
		
		thread0.start();
		thread1.start();
		thread2.start();
		
		Thread.sleep(100);
		
		System.out.println(list);
		
	}
	
	static class MyRunnable implements Runnable {
		
		@Override
		public void run() {
			list.add(Thread.currentThread().getName());
		}		
	}
}
