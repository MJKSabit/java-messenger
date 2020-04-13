package github.mjksabit;

public class NewUserFailedResponse extends Response {
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() {
        System.out.println("Could not create new user, username not available...");
        return null;
    }
}
