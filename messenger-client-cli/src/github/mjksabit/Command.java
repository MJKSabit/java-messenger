package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;

abstract public class Command {
    private static BufferedWriter serverOut;
    public static void setServerOut(BufferedWriter out) {
        serverOut = out;
    }

    protected boolean userLoggedIn() {
        return ServerConnect.username != null;
    }

    protected static void sendRequest (String requestText, JSONObject requestObject) throws IOException {
        sendRequest(requestText, requestObject.toString());
    }

    protected static void sendRequest (String requestText, String requestArguments) throws IOException {
        serverOut.write(requestText);
        serverOut.newLine();
        serverOut.write(requestArguments);
        serverOut.newLine();
        serverOut.flush();
    }

    abstract void ADDED_TO_THE_FACTORY();

    abstract boolean executeWithResponse() throws JSONException, IOException; // true if server communication is done
}
