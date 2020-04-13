package github.mjksabit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListMessageBoxRequest extends Request{
    @Override
    void ADDED_TO_FACTORY() {
        // true
    }

    @Override
    public String handle() throws JSONException {
        JSONObject box;
        JSONArray boxes = new JSONArray();

        User currentUser = context.currentUser;

        ArrayList<Integer> messageIds = currentUser.getMessageBoxes();

        for (int data : messageIds) {
            box = new JSONObject();
            box.put("id", data);
            box.put("name", currentUser.getUsernameOfMessage(data));
            boxes.put(box);
        }

        return "list_msg_box"+"\n"+
                boxes.toString();
    }
}
