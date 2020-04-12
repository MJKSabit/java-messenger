package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

public class NewUserRequest extends Request {
    @Override
    public String handle() {
        try {
            JSONObject userInfo = new JSONObject(arg);

            String username = userInfo.getString("username");
            String password = userInfo.getString("password");

            if(!Users.userExists(username)) {
                Users.addUser(username, password);
                return "new_user_success"+"\n"+
                        NO_JSON;
            }
        } catch (JSONException e) {

        }

        return "new_user_failed"+"\n"+
                NO_JSON;
    }
}
