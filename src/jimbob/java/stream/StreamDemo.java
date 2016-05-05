package jimbob.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Android");
		list.add("Java");
		list.add("Ios");
		list.add("jsp");
		list.add("ORACLE");
		// list.forEach(System.out::println);
		Stream<String> stream = list.stream();
		// 取消重复数据,不改变list的值
		// System.out.println(stream.distinct().count());
		// List<String> newList = stream.distinct().collect(Collectors.toList());
		// List<String> newList = stream.distinct()
		// .map((x)->x.toLowerCase())
		// .filter((x)->x.contains("a"))
		// .collect(Collectors.toList());
		// 可以进行分页
		// List<String> newList = stream.distinct()
		// .map((x)->x.toLowerCase())
		// .skip(2)
		// .limit(2)
		// .collect(Collectors.toList());
		// newList.forEach(System.out::println);

		// 匹配过程，进行数据查询
		Predicate<String> p1=(x)->x.contains("Ios");
		Predicate<String> p2=(x)->x.contains("jsp");
		if(stream.anyMatch(p1.or(p2))){
			System.out.println("存在");
		}

	}
}
