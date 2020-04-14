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

    protected String[] args;

    protected void setExpectedArgs(String[] argDetails) {
//        if (args.length != argDetails.length){
//            args = new String[argDetails.length];
//
//            System.out.println("Enter Arguments: ");
//            for (int i=0; i<argDetails.length; i++) {
//                System.out.print(argDetails[i]+" :");
//                args[i] = ServerConnect.scanner.nextLine();
//            }
//        }
//        else {
            System.out.println("Arguments:");
            for (int i=0; i<argDetails.length; i++) {
                System.out.println(argDetails[i]+": "+args[i]);
//            }
        }
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    protected boolean userLoggedIn() {
        return ServerConnect.username != null;
    }

    protected void logInPrompt() {
        System.out.println("Log in First!");
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
