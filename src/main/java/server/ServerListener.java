package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread {

	@Override
	public void run() {
		ServerSocket serverSocket = null;
		boolean clientOnline = false;
		try {
			serverSocket = new ServerSocket(12345);
			clientOnline = true;
			while (clientOnline) {
				Socket socket = serverSocket.accept();
				System.out.println("Client connect 12345 port");
				FacilitySocket facilitySocket = new FacilitySocket(socket);
				FacilitySocketManager.getManager().add(facilitySocket);
				facilitySocket.start();
			}
		} catch (IOException e) {
			clientOnline = false;
			e.printStackTrace();
		}
	}

	public static void main(String args[]){
		System.out.println("start socket...");
		new ServerListener().start();
	}
}