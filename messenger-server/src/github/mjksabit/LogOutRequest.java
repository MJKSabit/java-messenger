package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

public class LogOutRequest extends Request{
    @Override
    void ADDED_TO_FACTORY() {
        // true
    }

    @Override
    public String handle() throws JSONException {
        String JSON = String.format("{ username: \"%s\" }", context.currentUser.getUsername());
        context.currentUser = null;

        return "logged_out"+"\n"+
                JSON;
    }
}
