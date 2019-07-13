package testPra;

public class positiveD extends FunctionDecorator {

	public positiveD(Function f) {
		super(f);
		// TODO Auto-generated constructor stub
	}


	@Override
	public int getValue(int x) throws OutOfDomainException {
		if(x< f.getDomainStart() || x > f.getDomainEnd())
			throw new OutOfDomainException();
		return f.getValue(x) >0 ? f.getValue(x):0;
	}

	
	public static void main(String []args) {
		FunctionDecorator t = new positiveD(new Function() {

			@Override
			public int getValue(int x) throws OutOfDomainException {
				if(x< getDomainStart() || x> getDomainEnd())
					throw new OutOfDomainException();
				return 2*x;
			}

			@Override
			public int getDomainStart() {
				// TODO Auto-generated method stub
				return -2;
			}

			@Override
			public int getDomainEnd() {
				// TODO Auto-generated method stub
				return 4;
			}
			
		});
		
		for(Integer x : t)
			System.out.println("value = " + x.toString());
	}
}
