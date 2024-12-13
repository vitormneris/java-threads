package application;

public class Main {

	public static void main(String[] args) {
		// Thread atual
		Thread t = Thread.currentThread();

		// Nova Thread
		Thread t1 = new Thread(new MeuRunnable());
		//  t1.run(); apenas executando na mesma Thread, NÃO FAZER!
		t1.start(); // executando em uma nova Thread
		
		// Nome da Thread
		System.out.println(t.getName());
		
		// Nova Thread com função lambda
		Thread t2 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
		});
		t2.start(); // Iniciando outra thread
		// t2.start(); Não é possível iniciar duas vezes a mesma thread
	}
	
	static class MeuRunnable implements Runnable {
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
	}

}
