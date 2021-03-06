package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class LogOutCommand extends Command {
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    boolean executeWithResponse() throws JSONException, IOException {
        if (!userLoggedIn()) {
            logInPrompt();
            return false;
        }
        ServerConnect.username = null;

        sendRequest("log_out", new JSONObject("{}"));
        return true;
    }
}
