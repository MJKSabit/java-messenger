package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

public class NewMessageBoxRequest extends Request{
    @Override
    void ADDED_TO_FACTORY() {
        //true
    }

    @Override
    public String handle() throws JSONException {

        JSONObject object = new JSONObject(arg);

        User creator = context.currentUser;
        User receiver =  Users.getUser(object.getString("other"));

        if (receiver == null && receiver == creator) {
            return "msgbox_create_failed"+"\n"+NO_JSON;
        }

        return "msgbox_create_success"+"\n"+
                "{\"box_id\" : 0 }";
    }
}
