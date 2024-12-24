package com.example.book.utils;

import java.net.Socket;
import java.net.InetSocketAddress;

public class PortTester {
	public boolean isPortOpen(String host, int port) {
		try {
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress(host, port), 2000);
			socket.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
