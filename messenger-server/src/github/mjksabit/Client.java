package github.mjksabit;

import org.json.JSONException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client implements Runnable{
    final Socket clientSocket;

    User currentUser = null;

    InputStream inputStream = null;
    OutputStream outputStream = null;

    BufferedWriter out = null;
    BufferedReader in = null;

    public Client(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client Connected...");

            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();

            in = new BufferedReader(new InputStreamReader(inputStream));
            out = new BufferedWriter(new OutputStreamWriter(outputStream));

            String requestText, args, response;
            Request request;

            do {
                requestText = in.readLine();
                args = in.readLine();

                request = FactoryRequest.getRequest(requestText, args, this);

                if (request instanceof SignInRequest){
                    currentUser = ((SignInRequest) request).getUser();
                }

                response = request.handle();

                out.write(response);
                out.newLine();
                out.flush();

            } while (!(request instanceof ExitRequest));

            in.close();
            out.close();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            // Nothing, normal Exit
        }finally {
            System.out.println("Client Exit");
            try {
                if(inputStream!=null) inputStream.close();
                if (outputStream!=null) outputStream.close();
                if (clientSocket!=null) clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
