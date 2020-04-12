package github.mjksabit;

public class NewUserFailedResponse extends Response {
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public void execute() {
        System.out.println("Could not create new user, username not available...");
    }
}
