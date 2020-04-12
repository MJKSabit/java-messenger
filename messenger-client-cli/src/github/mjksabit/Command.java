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

    protected static void sendRequest (String requestText, JSONObject requestObject) throws IOException {
        serverOut.write(requestText);
        serverOut.newLine();
        serverOut.write(requestObject.toString());
        serverOut.newLine();
        serverOut.flush();
    }

    abstract void ADDED_TO_THE_FACTORY();

    abstract boolean executeWithResponse() throws JSONException, IOException; // true if server communication is done
}
