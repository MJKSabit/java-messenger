package github.mjksabit;

import org.json.JSONException;

public class SignUpErrorResponse extends Response{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public void execute() throws JSONException {
        System.out.println("Username/Password do not match!!!");
    }
}