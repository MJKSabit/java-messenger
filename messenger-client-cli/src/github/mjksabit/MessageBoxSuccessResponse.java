package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

public class MessageBoxSuccessResponse extends Response{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() throws JSONException {
        JSONObject msgBox = new JSONObject(arg);

        System.out.println("Message Box Created with ID: "+msgBox.getInt("id"));

        return "listmsgbox";
    }
}
