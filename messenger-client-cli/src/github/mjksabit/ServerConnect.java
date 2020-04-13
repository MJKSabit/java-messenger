package github.mjksabit;

import org.json.JSONException;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerConnect {
    private final static String SERVER = "127.0.0.1";
    private final static int port = 10500;

    public static String username = null;

    public static Scanner scanner = new Scanner(System.in);

    Socket socket = null;

    InputStream inputStream = null;
    OutputStream outputStream = null;

    public ServerConnect() {
        try {
            socket = new Socket(SERVER, port);
            socket.setSoTimeout(10000); // 10s server connect time

            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream));
            Command.setServerOut(out);

            String commandText = null;
            String responseText, responseObject;
            Command command;

            do {
                if (commandText == null) commandText = scanner.nextLine();

                command = FactoryCommand.getCommand(commandText);

                boolean hasResponse = command.executeWithResponse();

                if(!hasResponse) continue;

                Response response;

                responseText = in.readLine();
                responseObject = in.readLine();

                System.out.println(responseText);

                response = FactoryResponse.getResponse(responseText, responseObject);

                commandText = response.executeWithNextCommand();

            } while (!(command instanceof ExitCommand));

            in.close();
            out.close();

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream!=null) inputStream.close();
                if (outputStream!=null) outputStream.close();
                if (socket!=null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
