package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	// As listas comuns não são preparadas para lidar com multithreads, é possível que
	// duas threads tentem fazer a inserção de dados aos mesmo tempo, e causar a perca
	// das informações. Para corrigir este problemas é possível usar a linha abaixo:
	public static List<String> list = Collections.synchronizedList(new ArrayList<>());
	//Collections.synchronizedList() fornece uma instância de uma lista preparada para 
	//lidar com operações vinda de múltiplas threads
	
	public static void main(String[] args) throws InterruptedException {
		MyRunnable myRunnable = new MyRunnable();
		
		
		Thread thread0 = new Thread(myRunnable);		
		Thread thread1 = new Thread(myRunnable);
		Thread thread2 = new Thread(myRunnable);
		
		thread0.start();
		thread1.start();
		thread2.start();
		
		// Esta linha faz a thread main esperar 100 milisegundos
		Thread.sleep(100); // É necessário para que não ocorra exceção para o caso das
		// threads não terminarem sua execução antes de executar a linha de baixo
		
		
		System.out.println(list);
		
	}
	
	static class MyRunnable implements Runnable {
		
		@Override
		public void run() {
			list.add(Thread.currentThread().getName());
		}		
	}
}
