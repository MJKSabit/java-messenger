package github.mjksabit;

public class NewUserFailedResponse extends Response {
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() {
        sout("Could not create new user, username not available...");
        return null;
    }
}
