package org.campus02.klausur;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class GameClient implements Runnable {
	private final Game game;
	private final Socket client;
	private String name;

	public GameClient(Game game, Socket client) {
		this.game = game;
		this.client = client;
	}

	@Override
	public void run() {
		try {
			handleRequest();
		} catch (IOException | DataFileException e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleRequest() throws IOException, DataFileException {
		try (Scanner is = new Scanner(new BufferedInputStream(client.getInputStream()));
			 PrintWriter os = new PrintWriter(new BufferedOutputStream(client.getOutputStream()))) {
			while (is.hasNextLine()) {
				String request = is.nextLine();
				if (request.startsWith("NAME "))
					this.name = request.substring(5);
				else if (request.startsWith("TRY "))
					os.println(game.tryNumber(request.substring(4)));
				else if ("EXIT".equals(request))
					return;

				if (game.isFinished()) {
					os.println("Congratulations, you've found the number! Restarting game.");
					game.loadNumber();
				}

				os.flush();
			}
		}
	}
}
