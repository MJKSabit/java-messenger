package github.mjksabit;

import org.json.JSONException;

public class MessageBoxFailedResponse extends Response{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() throws JSONException {
        sout("Message Box could not be created...");
        return null;
    }
}
