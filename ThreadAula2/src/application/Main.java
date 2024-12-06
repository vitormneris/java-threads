package application;

public class Main {
	
	static int a;
	
	static int b;

	
	public static void main(String[] args) 
	{
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
	}
	
	static class MyRunnable implements Runnable 
	{			
		static Object lock1 = new Object();
		static Object lock2 = new Object();
	
		
		@Override
		public void run() 
		{

			String threadName = Thread.currentThread().getName();		
			
			int x;
			int y;
			
			synchronized(lock1) 
			{
				a = a  + 1;	
				x = a;
			}
			
			synchronized(lock2) 
			{
				a = a + 1;
				y = a;
			}
			
			System.out.println(threadName + " : a = " + x);	
			System.out.println(threadName + " : b = " + y);	
		}
	}
}
