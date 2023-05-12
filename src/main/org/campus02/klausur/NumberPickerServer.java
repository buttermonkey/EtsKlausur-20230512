package org.campus02.klausur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NumberPickerServer {
	public static void main(String[] args) {
		try (ServerSocket listener = new ServerSocket(1111)) {
			while (true) {
				Socket conn = listener.accept();
				try {
					Runnable game = new GameClient(new Game(), conn);
					new Thread(game).start();
				} catch (DataFileException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
