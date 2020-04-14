package github.mjksabit;

import org.json.JSONException;

import java.io.IOException;

public class ShowMessageBoxCommand extends Command{
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

        setExpectedArgs(new String[] {
                "MessageBoxId"
        });

        ServerConnect.controller.msgBoxId = Integer.parseInt(args[0]);
        sendRequest("showmsg", "{\"id\": "+args[0]+"}");

        return true;
    }
}
