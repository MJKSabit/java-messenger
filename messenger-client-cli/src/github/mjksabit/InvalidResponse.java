package github.mjksabit;

public class InvalidResponse extends Response {
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public void execute() {
        System.out.println("Invalid Response...");
    }
}
