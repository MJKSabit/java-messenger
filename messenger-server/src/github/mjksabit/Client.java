package github.mjksabit;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client implements Runnable{
    final ServerSocket serverSocket;

    Socket clientSocket = null;

    InputStream inputStream = null;
    OutputStream outputStream = null;


    BufferedWriter out = null;
    BufferedReader in = null;

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

            in = new BufferedReader(new InputStreamReader(inputStream));
            out = new BufferedWriter(new OutputStreamWriter(outputStream));

            String commandString;
            Command command;

            do {
                commandString = in.readLine();
                command = readCommand(commandString);
                command.execute();
            } while (! (command instanceof CommandExit));

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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Command readCommand(String commandString) throws IOException{
        Command command = CommandFactory.getCommand(commandString);

        int numberOfArguments = command.numberOfArguments();
        String[] args = new String[numberOfArguments];

        for (int i=0; i<numberOfArguments; i++)
            args[i] = in.readLine();

        command.setArgs(args);

        return command;
    }

    private void send(String message) throws IOException {
        out.write(message);
        out.flush();
    }

    private void getCommand() {

    }
}
