package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class NewMessageBoxCommand extends Command{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    boolean executeWithResponse() throws JSONException, IOException {

        if (ServerConnect.username == null) {
            System.out.println("Log in first...");
            return false;
        }

        System.out.print("Enter Other's Username: ");
        String otherUser = ServerConnect.scanner.nextLine();

        JSONObject object = new JSONObject();
        object.put("other", otherUser);

        sendRequest("new_msg_box", object);
        return true;
    }
}
