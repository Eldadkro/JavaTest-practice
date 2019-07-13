package testPra;

public class ex5T {

	private boolean block = true;
	private Object lock = new Object();
	
	private boolean block2 = true;
	private Object lock2 = new Object();
	
	
	
	public static void main(String []args) {
		new ex5T().example();
	}
	
	public void example() {
		System.out.println(Thread.currentThread().getName() + "- before");
		Thread t = new Thread(new sub());
		t.start();
		while(block)
			synchronized (lock) {
				try {
					lock.wait();
				} catch (InterruptedException e) {}
			}
		
		System.out.println(Thread.currentThread().getName() + "- after");
		synchronized (lock2) {
			block = true;
			lock2.notifyAll();
		}
	}
	private class sub implements Runnable{

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "- before");
			while(block)
				synchronized (lock) {
					block = false;
					lock.notifyAll();
							
				}
			while(!block)
				synchronized (lock2) {
					try {
					lock2.wait();
					}
					catch (InterruptedException e) {}
				}
			System.out.println(Thread.currentThread().getName() + "- after");
		}
		
	}
}
