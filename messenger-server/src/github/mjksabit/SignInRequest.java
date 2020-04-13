package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

public class SignInRequest extends Request{
    @Override
    void ADDED_TO_FACTORY() {
        // true
    }

    @Override
    public String handle() throws JSONException {
        User user = getUser();

        if (user == null) {
            return "login_error"+"\n"+
                    NO_JSON;
        }
        else {
            return "login_success"+"\n"+
                    arg;
        }
    }

    public User getUser() throws JSONException {
        JSONObject object = new JSONObject(arg);

        String username = object.getString("username");
        String password = object.getString("password");

        User user = Users.getUser(username, password);
        context.currentUser = user;
        return user;
    }
}
