package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class SignUpCommand extends Command{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    boolean executeWithResponse() throws JSONException, IOException {

        System.out.print("Username: ");
        String username = ServerConnect.scanner.nextLine();

        System.out.print("Password: ");
        String password = ServerConnect.scanner.nextLine();

        JSONObject object = new JSONObject();

        object.put("username", username);
        object.put("password", password);

        sendRequest("new_user", object);

        return true;
    }
}
