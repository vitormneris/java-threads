package application;

import java.lang.Thread.State;

public class Main {
	private static volatile int number = 0;
	private static volatile boolean preparated = false;	
	
	public static void main(String[] args) {		
		while (true) 
		{
			Thread thread0 = new Thread(new MyRunnable());
			thread0.start();

			Thread thread1 = new Thread(new MyRunnable());
			thread1.start();
			
			Thread thread2 = new Thread(new MyRunnable());
			thread2.start();
			
			number = 42;
			preparated = true;
			
			while (thread0.getState() != State.TERMINATED ||
					thread1.getState() != State.TERMINATED ||
					thread2.getState() != State.TERMINATED)
			{
				
			}
			
			number = 0;
			preparated = false;
		}
	}
	
	public static class MyRunnable implements Runnable {
		@Override
		public void run() {
			while(!preparated) 
			{
				Thread.yield();
			}
			

			if (number != 42) 
			{
				System.out.println(number);
				throw new IllegalStateException("DEU ERRO :O");
			}
		}
	}

}
