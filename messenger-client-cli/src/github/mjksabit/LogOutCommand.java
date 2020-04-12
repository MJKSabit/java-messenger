package github.mjksabit;

import org.json.JSONException;

import java.io.IOException;

public class LogOutCommand extends Command {
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    boolean executeWithResponse() throws JSONException, IOException {
        ServerConnect.username = null; // Consider executing with response
        System.out.println("Logged Out Successfully...");
        return false;
    }
}
