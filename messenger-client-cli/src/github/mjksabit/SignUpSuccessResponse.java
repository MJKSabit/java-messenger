package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpSuccessResponse extends Response {

    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() throws JSONException {
        JSONObject object = new JSONObject(arg);
        ServerConnect.username = object.getString("username");

        System.out.println(String.format("User (%s) Login Successful...", ServerConnect.username));

        return "listmsgbox";
    }
}
