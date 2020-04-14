package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

public class MessageSentResponse extends Response{
    @Override
    void ADDED_TO_THE_FACTORY() {
        //true
    }

    @Override
    public String executeWithNextCommand() throws JSONException {
        JSONObject read = new JSONObject(arg);
        // sout("Message Sent Successful!");

        return "showmsg ~"+
                read.getInt("id");
    }
}
