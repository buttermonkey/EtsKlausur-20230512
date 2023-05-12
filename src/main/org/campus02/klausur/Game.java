package org.campus02.klausur;

import java.util.List;

public class Game {
	private String currentNumber;
	private int counter = 0;
	private int countAttempts = 0;
	private boolean isFinished = false;

	public Game() throws DataFileException {
		loadNumber();
	}

	public void loadNumber() throws DataFileException {
		List<String> numbers = new NumberLoader().load();
		currentNumber = numbers.get(counter % numbers.size());
		counter = (counter + 1) % numbers.size();
		countAttempts = 0;
		isFinished = false;
	}

	public String tryNumber(String number) {
		countAttempts++;
		String answer = "";
		for (int i = 0; i < currentNumber.length(); i++) {
			if (number.length() <= i)
				answer += "x";
			else if (number.charAt(i) == currentNumber.charAt(i))
				answer += number.charAt(i);
			else
				answer += "x";
		}
		return answer;
	}

	public String getCurrentNumber() {
		return currentNumber;
	}

	public int getCounter() {
		return counter;
	}

	public int getCountAttempts() {
		return countAttempts;
	}

	public boolean isFinished() {
		return isFinished;
	}
}
