package testPra;

import java.util.Iterator;

public class Sum implements Function,Iterable<Integer>{

	private Function f;
	
	public Sum(Function f) {
		this.f = f;
	}
	@Override
	public int getValue(int x) throws OutOfDomainException {
		if(x< f.getDomainStart() || x > f.getDomainEnd())
			throw new OutOfDomainException();
		int sum = 0;
		for(int i = f.getDomainStart(); i<x ; i++) {
			sum += f.getValue(i);
		}
		return sum;
	}

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
		return null;
	}

}
