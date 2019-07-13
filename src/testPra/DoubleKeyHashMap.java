package testPra;

import java.util.HashMap;
import java.util.Scanner;

public class DoubleKeyHashMap<K,V> {
	
	private HashMap<K, HashMap<K,V>> map = new HashMap<>();
	
	
	public void put(K k1,K k2,V v) {
		if(map.containsKey(k1)) {
			HashMap<K,V> tmp = map.get(k1);
			tmp.put(k2, v);
			map.put(k1, tmp);
		}
		else {
			HashMap<K,V> tmp = new HashMap<>();
			tmp.put(k2, v);
			map.put(k1, tmp);
		}
	}
	
	public static void main(String []args) {
		Scanner s = new Scanner(System.in);
		
	}

}
