package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

public class NewMessageRequest extends Request{
    @Override
    void ADDED_TO_FACTORY() {
        // true
    }

    @Override
    public String handle() throws JSONException {
        JSONObject jsonObject = new JSONObject(arg);

        MessageBox messageBox = context.currentUser.getMessageBox(jsonObject.getInt("id"));

        if(messageBox == null) {
            return "forbidden"+"\n"+
                    "{\"message\" : \"Error 403 : Forbidden Access\"}";
        }

        messageBox.addMessage(context.currentUser, jsonObject.getString("message"));



        return "msg_sent"+"\n"+"{\"id\" : "+jsonObject.getInt("id")+" }";
    }
}
