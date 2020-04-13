package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

public class Message {
    User sender;
    String text;

    public Message(User sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public JSONObject getJSON() throws JSONException {
        JSONObject object = new JSONObject();
        object.put("sender", sender.getUsername());
        object.put("text", text);
        return object;
    }
}
