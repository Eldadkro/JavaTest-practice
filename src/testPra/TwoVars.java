package testPra;

public class TwoVars<A,B> {
	
	private A a;
	private B b;
	
	public TwoVars(A a,B b) {
		this.a = a;
		this.b = b;
		
		// TODO Auto-generated constructor stub
	}
	
	public B f(A a) {
		if(this.a.equals(a))
			return b;
		return null;
	}

}
