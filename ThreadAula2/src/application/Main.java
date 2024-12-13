package application;

public class Main {
	
	static int a;
	
	static int b;

	
	public static void main(String[] args) 
	{
		Runnable myRunnable = new MyRunnable();
		
		// Todas as threads usando o mesmo Runnable, o que causa a conrrência
		// entre as threads
		Thread thread0 = new Thread(myRunnable);
		Thread thread1 = new Thread(myRunnable);
		Thread thread2 = new Thread(myRunnable);
		Thread thread3 = new Thread(myRunnable);
		Thread thread4 = new Thread(myRunnable);

		// Execução de múltiplas threads
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
	
	static class MyRunnable implements Runnable 
	{			
		
		// Objetos com a utilidade de eliminar a conrrência entre os synchronized
		static Object lock1 = new Object();
		static Object lock2 = new Object();
	
		
		@Override
		public void run() 
		{
			String threadName = Thread.currentThread().getName();		
			
			int x;
			int y;
			
			// Sincronizando o momento em a variável 'a' é incrementada
			// e salvando seu valor no escopo do método
			// dessa forma não há como a thread imprimir o valor errado da
			// sua incrementação
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
