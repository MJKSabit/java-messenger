package github.mjksabit;

import javafx.application.Platform;
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

        String msgBoxName = object.getString("name");

        Platform.runLater(()-> {
            ServerConnect.controller.setMessageBoxName(msgBoxName);
            ServerConnect.controller.messages.clear();
        });

        JSONArray messages = object.getJSONArray("messages");
        JSONObject message;

        for (int i=0; i<messages.length(); i++) {
            message = messages.getJSONObject(i);
            String sender = message.getString("sender");
            String msgText = message.getString("text");
            Platform.runLater( () -> ServerConnect.controller.messages.add(new MessageHBox(sender.equals(ServerConnect.username), msgText, sender)));
        }

        return null;
    }
}
