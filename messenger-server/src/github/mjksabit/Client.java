package github.mjksabit;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client implements Runnable{
    final ServerSocket serverSocket;

    Socket clientSocket = null;

    InputStream inputStream = null;
    OutputStream outputStream = null;

    public Client(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            clientSocket = serverSocket.accept();

            System.out.println("Client Connected...");

            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream));

            String command;
            while (!(command=in.readLine()).equals("end")){
                System.out.println(command);
                out.write("Server Says: "+command+"\n");
                out.flush();
            }

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(inputStream!=null) inputStream.close();
                if (outputStream!=null) outputStream.close();
                if (clientSocket!=null) clientSocket.close();
                if (serverSocket!=null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
