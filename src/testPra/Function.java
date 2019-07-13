package testPra;

public interface Function {


	public int getValue(int x) throws OutOfDomainException;
	
	public int getDomainStart();
	
	public int getDomainEnd();
	
}
