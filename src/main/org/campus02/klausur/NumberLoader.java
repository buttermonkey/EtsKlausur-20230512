package org.campus02.klausur;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberLoader {

	public static final String DATA_FILE = "data/numberpicker_hk1.txt";

	public List<String> load() throws DataFileException {
		try {
			return readDataFile(DATA_FILE);
		} catch (FileNotFoundException e) {
			throw new DataFileException("Uh oh, couldn't open data file: '" + DATA_FILE + "'", e);
		} catch (IOException e) {
			throw new DataFileException("Uh oh, something terrible happened while reading data file '" + DATA_FILE + "'", e);
		}
	}

	private static List<String> readDataFile(String datafile) throws IOException {
		Set<String> numbers = new HashSet<>();
		BufferedReader is = new BufferedReader(new FileReader(datafile));
		String number;
		while ((number = is.readLine()) != null) {
			if (!number.isBlank())
				numbers.add(number);
		}
		return new ArrayList<>(numbers);
	}
}
