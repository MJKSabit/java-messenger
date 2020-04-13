package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

public class LogOutResponse extends Response{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public void execute() throws JSONException {
        JSONObject jsonObject = new JSONObject(arg);
        System.out.println(jsonObject.getString("username") + " logged Out successfully");
    }
}
