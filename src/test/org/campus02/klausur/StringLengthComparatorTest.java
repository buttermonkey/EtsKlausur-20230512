package org.campus02.klausur;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringLengthComparatorTest {
	@Test
	void sortOrderIsCorrect() {
		String[] data = { "9", "333", "111", "0000", "222" };
		String[] expected = { "9", "111", "222", "333", "0000" };

		Arrays.sort(data, new StringLengthComparator());

		assertArrayEquals(expected, data);
	}
}