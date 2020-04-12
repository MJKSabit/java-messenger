package github.mjksabit;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerConnect {
    private final static String SERVER = "127.0.0.1";
    private final static int port = 10500;

    private static Scanner scanner = new Scanner(System.in);

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

            String command, arg;
            String responseText, responseObject;
            Response response;

            do {
                command = scanner.nextLine();
                arg = scanner.nextLine();

                System.out.println("Input taken...");

                out.write(command);
                out.newLine();
                out.write(arg);
                out.newLine();

                out.flush();

                responseText = in.readLine();
                responseObject = in.readLine();

                System.out.println(responseText);

                response = FactoryResponse.getResponse(responseText, responseObject);

                response.execute();

            } while (!(response instanceof ExitResponse));

            in.close();
            out.close();

        } catch (IOException e) {
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
