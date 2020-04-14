package github.mjksabit;

import org.json.JSONException;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerConnect {
    private final static String SERVER = "127.0.0.1";
    private final static int port = 10500;

    public static Controller controller;

    public static String username = null;

    public static Scanner scanner = new Scanner(System.in);

    Socket socket = null;

    InputStream inputStream = null;
    OutputStream outputStream = null;

    BufferedReader in;
    BufferedWriter out;

    public ServerConnect() {
        try {
            socket = new Socket(SERVER, port);
            socket.setSoTimeout(10000); // 10s server connect time

            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();


            in = new BufferedReader(new InputStreamReader(inputStream));
            out = new BufferedWriter(new OutputStreamWriter(outputStream));

            Command.setServerOut(out);

//            String commandText = null;
//            String responseText, responseObject;
//            Command command = null;
//
//            do {
//                if (commandText == null || (command instanceof UnknownCommand)) commandText = scanner.nextLine();
//
//                command = FactoryCommand.getCommand(commandText);
//
//                boolean hasResponse = command.executeWithResponse();
//
//                commandText = "";
//
//                if(!hasResponse) continue;
//
//                Response response;
//
//                responseText = in.readLine();
//                responseObject = in.readLine();
//
//                System.out.println(responseText);
//
//                response = FactoryResponse.getResponse(responseText, responseObject);
//
//                commandText = response.executeWithNextCommand();
//
//            } while (true);
//
//            in.close();
//            out.close();
//
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                if(inputStream!=null) inputStream.close();
//                if (outputStream!=null) outputStream.close();
//                if (socket!=null) socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

        controller.showNotification("Connection Successful...");

    }

    public synchronized void executeCommand(String commandText) {
        if (commandText == null) return;

        String responseText, responseObject;
        Response response;
        Command command = FactoryCommand.getCommand(commandText);
        commandText = null;

        try {
            boolean hasResponse = command.executeWithResponse();

            if(!hasResponse) return;

            responseText = in.readLine();
            responseObject = in.readLine();

            response = FactoryResponse.getResponse(responseText, responseObject);
            commandText = response.executeWithNextCommand();

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        if(commandText!=null) executeCommand(commandText);
    }
}
