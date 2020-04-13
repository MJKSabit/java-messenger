package github.mjksabit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListMessageBoxResponse extends Response {
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() throws JSONException {
        JSONArray list = new JSONArray(arg);
        JSONObject line;

        System.out.println("Message Box List: ");

        System.out.println("======================");
        for (int i=0; i<list.length(); i++) {
            line = list.getJSONObject(i);
            System.out.println(line.getInt("id")+line.getString("name"));
        }
        System.out.println("=====================");

        return null;
    }
}
