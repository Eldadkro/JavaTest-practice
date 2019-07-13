package testPra;

import java.util.*;

public class Cascade {

	private List<Thread> l = new ArrayList<>();
	private int current = 0;
	private int n = 0;
	
	public Cascade(int n) {
		this.n = n;
		// TODO Auto-generated constructor stub
	}
	public void runExample(int n)  {
		for(int i=0;i<n;i++) {
			l.add(new Thread(new sub()));
			l.get(i).start();
		}
		l.get(0).interrupt();

	}
	
	public static void main(String []args) {
		new Cascade(4).runExample(4);
	}
	
	private class sub implements Runnable{
		
		public void run() {
			while(true) {
				try {
					while(true)
						Thread.sleep(Long.MAX_VALUE);
				} catch(InterruptedException e) {}
				if(l.get(current % n).equals(Thread.currentThread())) {
					System.out.println(Thread.currentThread().getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {}
					l.get(++current % n).interrupt();
				}
			}
		}
	}
}
