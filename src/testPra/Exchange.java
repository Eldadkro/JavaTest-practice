package testPra;

public class Exchange<E> {

	boolean g1 = false,g2 = false;
	Object lock1 = new Object(),lock2 = new Object() ;
	E data1,data2;
	
	public E give1(E e) {
		synchronized (lock1) {
		data1 = e;
		g1 = true;
		while(!g2)
			
				try{
					lock1.wait();
					}
				catch (InterruptedException ex) {}
		lock1.notifyAll();
			}
		return data2;
	}
	
	public E give2(E e) {
		synchronized (lock1) {
		data2 = e;
		g2 = true;
		while(!g1)
				try{
					lock1.wait();
					}
				catch (InterruptedException ex) {}
		lock1.notifyAll();
			}
		return data1;
	}
	
	
	public static void main(String []args) {
		Exchange<String> ex = new Exchange();
		
		Thread t1 = new Thread(new Runnable() {
			public Exchange<String> exchange = ex;
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				System.out.println(Thread.currentThread().getName()+" "+exchange.give1("hi"));
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public Exchange<String> exchange=ex;
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				System.out.println(Thread.currentThread().getName()+" "+exchange.give2("hey"));			
			}
			
		});
		t1.start();
		t2.start();
		
	}
	
}
