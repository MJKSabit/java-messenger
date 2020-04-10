package github.mjksabit;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    final static int PORT = 911;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
	        new Thread(new Client(serverSocket)).start();
        }
    }
}
