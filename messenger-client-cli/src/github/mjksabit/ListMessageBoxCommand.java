package github.mjksabit;

import org.json.JSONException;

import java.io.IOException;

public class ListMessageBoxCommand extends Command{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    boolean executeWithResponse() throws JSONException, IOException {
        if(!userLoggedIn()) {
            logInPrompt();
            return false;
        }

        sendRequest("list_msg_box", "{}");

        return true;
    }
}
