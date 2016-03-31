import java.util.*;
public class HashMapTest{
	public static void main(String[] args) {

		HashMap<Integer,ArrayList<String>> hm=new HashMap<Integer,ArrayList<String>>();
		ArrayList<String> x = hm.get(1);

		if(x == null){
			x = new ArrayList<String>();
			x.add("abc");
		}
		hm.put(1,x);
		x = hm.get(1);
		System.out.println(x);
		//x.add("abc");
		//hm.put(1,x);
		// hm.put(1,"def");
		// for (Map.Entry m: hm.entrySet()) {
		// 	System.out.println(m.getKey()+" "+m.getValue());
		// }

	}
}