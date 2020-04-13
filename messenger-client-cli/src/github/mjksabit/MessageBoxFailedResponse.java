package github.mjksabit;

import org.json.JSONException;

public class MessageBoxFailedResponse extends Response{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() throws JSONException {
        System.out.println("Message Box could not be created...");
        return "listmsgbox";
    }
}
