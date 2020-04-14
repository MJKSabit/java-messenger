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
        int id = msgBox.getInt("id");

        sout("Message Box Created with ID: "+id);

        return "showmsg"+FactoryCommand.SEPERATOR+id;
    }
}
