package org.campus02.klausur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberLoaderTest {

	NumberLoader numberLoader;

	@BeforeEach
	void setUp() {
		numberLoader = new NumberLoader();
	}

	@Test
	void loadDoesNotThrow() {
		assertDoesNotThrow(() -> numberLoader.load());
	}

	@Test
	void loadLoadsNumbers() throws DataFileException {
		List<String> numbers = numberLoader.load();

		assertTrue(numbers.size() > 0);
	}

	@Test
	void loadDoesNotLoadDoubleNumbers() throws DataFileException {
		List<String> numbers = numberLoader.load();

		assertEquals(6, numbers.size());
	}
}