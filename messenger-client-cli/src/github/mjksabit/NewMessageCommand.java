package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class NewMessageCommand extends Command {
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    boolean executeWithResponse() throws JSONException, IOException {
        if(!userLoggedIn()){
            System.out.println("Log in first!");
            return false;
        }


        setExpectedArgs(new String[] {
                "Id", "Message"
        });

        JSONObject object = new JSONObject();
        object.put("id", Integer.parseInt(args[0]));
        object.put("message", args[1]);

        sendRequest("new_msg", object.toString());

        return true;
    }
}
