package org.finra.SQSProcess;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListProcessor {

	public static String listProcess(String firstName, String lastName, String intList) {
		String[] intArray = intList.split(",");
		List<Integer> list = Stream.of(intArray)
							.map(e -> Integer.parseInt(e))
							.collect(Collectors.toList());
		Collections.sort(list);
		StringBuilder sb = new StringBuilder(String.valueOf(list.get(0)));
		for(int i = 1; i < list.size(); i++) {
			sb.append("," + list.get(i));
		}
		return sb.toString();
	}
}
