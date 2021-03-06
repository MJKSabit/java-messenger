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

        if (!userLoggedIn()) {
            System.out.println("Log in first...");
            return false;
        }

        String otherUser;
        setExpectedArgs(new String[]{"Receiver Username"});
        otherUser = args[0];


        JSONObject object = new JSONObject();
        object.put("other", otherUser);

        sendRequest("new_msg_box", object);
        return true;
    }
}
