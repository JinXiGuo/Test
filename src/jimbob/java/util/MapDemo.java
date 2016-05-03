package jimbob.java.util;

import java.util.*;
/**
 * mapµÄÊä³öÊ¾·¶
 * @author 34773
 *
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<>();
		map.put("k1", "1");
		map.put("k2", "2");
		map.put("k3", "3");
		map.put("k4", "4");
		Set<Map.Entry<String, String>> set= map.entrySet();
		Iterator<Map.Entry<String,String>> iterator=set.iterator();
		while(iterator.hasNext()){
			Map.Entry<String, String> entry=iterator.next();
			System.out.println(entry.getKey()+"---"+entry.getValue());
		}
	}
}
