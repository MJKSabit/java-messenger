package github.mjksabit;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    final static int PORT = 10500;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        serverSocket = new ServerSocket(PORT);

        while (true){
            clientSocket = serverSocket.accept();
            new Thread(new Client(clientSocket)).start();
        }
    }
}
