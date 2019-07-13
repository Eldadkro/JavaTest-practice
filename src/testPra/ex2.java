package testPra;

import java.util.ArrayList;
import java.util.List;

public class ex2 {

	public interface blac{
		public int asd();
	}
	
	public static <E extends HasValue> List<E> filter(List<E> a,int atLeast){
		blac news = new blac(){
			
			public int asd() {
				
				return 0;
			}
		};
		
		news.asd();
		List<E> result = new ArrayList<>();
		for(E val: a) {
			if(val.value() >= atLeast)
				result.add(val);
		}
		return result;
	}
}
