import java.io.*;
import java.util.*;

public class HashMap_impl {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();

		//population of countries - sample
		hm.put("India", 135);
		hm.put("China", 200);
		hm.put("US", 30);
		hm.put("UK", 20);
		hm.put("Germany", 15);

		System.out.println(hm);

		hm.put("Poland", 100);

		System.out.println(hm);

		System.out.println(hm.containsKey("India"));
		System.out.println(hm.containsKey("CANADA"));

		Set<String> keys = hm.keySet();
		for(String key : keys) {
			System.out.println("key: "+key +", val: "+ hm.get(key));
		}
	}
}