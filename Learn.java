package com.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Learn {
	
	@SuppressWarnings("unchecked")
	public static void display(Object ob) {
		if(ob instanceof List) {
			((List<Object>) ob).stream().forEach(System.out::println);
			//((List<Object>) ob).stream().forEach(x->System.out.println(x));
			//((List<Object>) ob).forEach(System.out::println);
			
			line();
		}
		else if(ob instanceof Map) {
			((Map<Integer,Long>) ob).entrySet().stream().forEach(x->System.out.println("KEY : "+x.getKey()+" Value: "+x.getValue()));
		}else {
			System.out.println(ob);
		}
	}
	
	public static void line() {
		System.out.println("-----------------------------------------------");
	}
	
	public List<String> orderListByAsc(List<String> list) {
		
		List<String> ascOrderList = list.stream().sorted().collect(Collectors.toList());
		display(ascOrderList);
		return ascOrderList;
	}
	
	public List<String> orderListByDesc(List<String> list) {
		List<String> descOrderList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		display(descOrderList);
		return descOrderList;
	}
	
	public List<String> allCapital(List<String> list) {
		List<String> allCapitalList = list.stream().map(x->x.toUpperCase()).collect(Collectors.toList());
		//List<String> allCapitalList1 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		display(allCapitalList);
		return allCapitalList;
	}
	public List<String> firstLetterCapital(List<String> list) {
		List<String> firstLetterCapitalList = list.stream().map(x->String.valueOf(x.charAt(0)).toUpperCase()+x.substring(1)).collect(Collectors.toList());
		display(firstLetterCapitalList);
		return firstLetterCapitalList;
	}
	
	public List<Integer> distinctInteger(List<Integer> list) {
		List<Integer> distinctIntegerList = list.stream().distinct().toList();
		display(distinctIntegerList);
		return distinctIntegerList;
	}
	
	public void summaryStatics(List<Integer> list) {
		double avg = list.stream().mapToInt(x->x).summaryStatistics().getAverage();
		double distinctCount = list.stream().mapToInt(x->x).distinct().summaryStatistics().getCount();
		double max = list.stream().mapToInt(x->x).summaryStatistics().getMax();
		display("avg = "+avg+" distinctCount = "+distinctCount+" max = "+max);
		
	}
	
	public HashMap<Integer,Long> frequencyIntegerList(List<Integer> list) {
		Map<Integer,Long>  frequencyOfNumbers = list.stream().collect(Collectors.groupingBy(x->x,LinkedHashMap::new,Collectors.counting()));
		Map<Integer,Long>  frequencyOfNumbers1 = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		display(frequencyOfNumbers);
		return (HashMap<Integer, Long>) frequencyOfNumbers;

	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,1,2,2,2,3,4,4,5,5,5,5));
		Learn learn = new Learn();
		learn.frequencyIntegerList(list);
		

	}

}
