package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	
	public static List<String> list = Collections.synchronizedList(new ArrayList<>());
	
	public static List<String> list1 = new CopyOnWriteArrayList<>();

	public static Map<Integer, String> map = new ConcurrentHashMap<>();
	
	public static BlockingQueue<String> queue = new LinkedBlockingQueue<>();
	
	public static void main(String[] args) throws InterruptedException {

		Runnable myRunnable = new MyRunnable();
		
		Thread thread0 = new Thread(myRunnable);
		Thread thread1 = new Thread(myRunnable);
		Thread thread2 = new Thread(myRunnable);
		Thread thread3 = new Thread(myRunnable);
		Thread thread4 = new Thread(myRunnable);
		
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		Thread.sleep(10);
		System.out.print(list);

	}
	
	public static class MyRunnable implements Runnable {
		
		@Override
		public void run() {
			list.add(Thread.currentThread().getName());
		}
	}
}
