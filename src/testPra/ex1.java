package testPra;

public class ex1 {
	
	public static <E> void nullAll(E[] a, Predicate<E> p) {
		
		for(int i=0;i<a.length;i++)
			if(p.f(a[i]))
				a[i] = null;
	}
	
	public static class Bigger implements Predicate<Integer>{

		@Override
		public boolean f(Integer x) {
			return x.compareTo(Integer.valueOf(100))>0;
		}
	}
	
	public static void zero100(Integer[] a) {
		Bigger p = new Bigger();
		nullAll(a, p);
		for(int i=0;i<a.length;i++)
			a[i] = a[i] == null ? new Integer(0):a[i];
	}

}
