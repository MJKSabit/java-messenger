package github.mjksabit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowMessageResponse extends Response{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() throws JSONException {
        JSONObject object = new JSONObject(arg);

        System.out.println("=========================");
        String msgBoxName = object.getString("name");
        System.out.println(msgBoxName);

        JSONArray messages = object.getJSONArray("messages");
        JSONObject message;
        System.out.println("=========================");
        for (int i=0; i<messages.length(); i++) {
            message = messages.getJSONObject(i);
            System.out.println(message.getString("sender")+":"+
                    message.getString("text"));
        }
        System.out.println("=========================");

        return null;
    }
}
