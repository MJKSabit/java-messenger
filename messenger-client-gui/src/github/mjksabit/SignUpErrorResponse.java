package github.mjksabit;

import org.json.JSONException;

public class SignUpErrorResponse extends Response{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() throws JSONException {
        sout("Username/Password do not match!!!");
        return null;
    }
}
