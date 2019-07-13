package testPra;

public class Positive implements Function {
	
	private Function f;
	private int domainStart;
	private int domainEnd;
	
	public Positive(Function f) {
		this.f = f;
		domainStart = f.getDomainStart();
		domainEnd = f.getDomainEnd();
	}

	@Override
	public int getValue(int x) throws OutOfDomainException {
		int value = f.getValue(x);
		return value > 0 ? value : 0;
	}

	@Override
	public int getDomainStart() {
		return domainStart;
	}

	@Override
	public int getDomainEnd() {
		return domainEnd;
	}

}
