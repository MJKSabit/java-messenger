package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

public class ShowMessageRequest extends Request{
    @Override
    void ADDED_TO_FACTORY() {
        // true
    }

    @Override
    public String handle() throws JSONException {

        JSONObject read = new JSONObject(arg);
        JSONObject args =  context.currentUser.getMessages(read.getInt("id"));

        return "msgbox"+"\n"+
                args.toString();
    }
}
