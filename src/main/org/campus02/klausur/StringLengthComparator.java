package org.campus02.klausur;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return Comparator
				.comparing(String::length)
				.thenComparing(String::toString)
				.compare(o1, o2);
	}
}
