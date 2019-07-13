package testPra;

import java.util.Iterator;

public abstract class FunctionDecorator implements Function,Iterable<Integer> {
	
	protected Function f;
	
	public FunctionDecorator(Function f) {
		// TODO Auto-generated constructor stub
		this.f = f;
	}

	@Override
	public abstract int getValue(int x) throws OutOfDomainException ;

	@Override
	public int getDomainStart() {
		// TODO Auto-generated method stub
		return f.getDomainStart();
	}

	@Override
	public int getDomainEnd() {
		// TODO Auto-generated method stub
		return f.getDomainEnd();
	}
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new iter();
	}
	
	
	private class iter implements Iterator<Integer>{

		private int index = getDomainStart(),end = getDomainEnd();
		
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index<=end;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			try {
				return getValue(index++);
			} catch (OutOfDomainException e) {}
			return 0;
		}
		
	}

}
